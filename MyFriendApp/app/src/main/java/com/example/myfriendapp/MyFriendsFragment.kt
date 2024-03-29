import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfriendapp.MyFriend
import com.example.myfriendapp.MyFriendDao
import com.example.myfriendapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MyFriendsFragment : Fragment() {
    private var fabAddFriend : FloatingActionButton? = null
    private var listTeman : List<MyFriend>? = null
    private var db: AppDatabase? = null
    private var myFriendDao: MyFriendDao? = null

    companion object {
        fun newInstance(): MyFriendsFragment {
            return MyFriendsFragment()
        }
    }
        override fun onCreateView(
            inflater: LayoutInflater, container:
            ViewGroup?, savedInstanceState: Bundle?): View? {
            return inflater.inflate(
                R.layout.my_friends_fragment,
                container, false
            )
        }

        override fun onViewCreated(view: View, savedInstanceState:
        Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            initLocalDB()
            initView()
        }

        private fun initLocalDB() {
            db = AppDatabase.getAppDataBase(requireActivity())
            myFriendDao = db?.myFriendDao()
        }

        private fun initView() {
            fabAddFriend = activity?.findViewById(R.id.fabAddFriend)
            fabAddFriend?.setOnClickListener {
                (activity as MainActivity).tampilMyFriendsAddFragment() }

            ambilDataTeman()
            tampilTeman()
            
        }

        @SuppressLint("FragmentLiveDataObserve")
        private fun ambilDataTeman() {
            listTeman = ArrayList()
            myFriendDao?.ambilSemuaTeman()?.observe(this, Observer { r -> listTeman = r
                when {
                    listTeman?.size == 0 -> tampilToast("Belum ada data teman")

                        else -> {
                    tampilTeman()
                }
                }
            })
      }
    private fun tampilToast(message: String) {
        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
    }

        private fun tampilTeman() {
            val listMyFriends = view?.findViewById<RecyclerView>(R.id.ListMyFriends)
            listMyFriends?.layoutManager = LinearLayoutManager(activity)
            listMyFriends?.adapter = MyFriendAdapter(requireActivity(),
                listTeman as ArrayList<MyFriend>
            )
        }

        override fun onDestroy() {
            super.onDestroy()
            //this.clearFindViewByIdCache()
        }

}