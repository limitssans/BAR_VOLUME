package com.example.myfriend

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.my_friends_add_fragment.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MyFriendsAddFragment : Fragment() {
    private var btnSave: Button? = null

    companion object {
        fun newInstance(): MyFriendsAddFragment {
            return MyFriendsAddFragment()
        }
    }

    private var namaInput: String = ""
    private var emailInput: String = ""
    private var telpInput: String = ""
    private var alamatInput: String = ""
    private var genderInput: String = ""

    private var db: AppDatabase? = null
    private var myFriendsDao: MyFriendDao? = null
    override fun onCreateView(
        inflater: LayoutInflater, container:
        ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.my_friends_add_fragment,
            container, false
        )
    }

    override fun onViewCreated(
        view: View, savedInstanceState:
        Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)
        initLocalDB()
        initView()
    }

    private fun initLocalDB() {
        db = AppDatabase.getAppDataBase(requireActivity())
        myFriendsDao = db?.myFriendDao()
    }

    private fun initView() {

        btnSave?.setOnClickListener { validasiInput() }
        setDataSpinnerGender()
    }

    private fun setDataSpinnerGender() {
        val adapter = ArrayAdapter.createFromResource(
            requireActivity(),
            R.array.gender_list, android.R.layout.simple_spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        spinnerGender.adapter = adapter
    }

    private fun validasiInput() {
        namaInput = edtName.text.toString()
        emailInput = edtEmail.text.toString()
        telpInput = edtTelp.text.toString()
        alamatInput = edtAddress.text.toString()
        genderInput = spinnerGender.selectedItem.toString()

        when {
            namaInput.isEmpty() -> edtName.error = "Nama tidak bolehkosong"

            genderInput.equals("Pilih kelamin") ->
                tampilToast("Kelamin harus dipilih")

            emailInput.isEmpty() -> edtEmail.error = "Emailtidak boleh kosong"

            telpInput.isEmpty() -> edtTelp.error = "Telp tidak bolehkosong"

            alamatInput.isEmpty() -> edtAddress.error = "Alamat tidak boleh kosong"

            else -> {
                val teman = MyFriends(
                    nama = namaInput,
                    kelamin = genderInput,
                    email = emailInput,
                    telp = telpInput,
                    alamat = alamatInput
                )

                tambahDataTeman(teman)
            }
        }
    }
    private fun tambahDataTeman(teman: MyFriends) : Job {

        return GlobalScope.launch {
            myFriendsDao?.tambahTeman(teman)
            (activity as MainActivity).tampilMyFriendsAddFragment()
        }
    }
    private fun tampilToast(message: String) {
        Toast.makeText(requireActivity(),message,Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}

