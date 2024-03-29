package com.example.uklkasir.database

import androidx.room.*
@Dao
interface CafeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDetailTransaksi(detailTransaksi: DetailTransaksi)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMenu(menu: Menu)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMeja(meja: Meja)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTransaksi(transaksi: Transaksi)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Query("SELECT * FROM User WHERE email = :mEmail AND password = :mPass")
    fun login(mEmail: String, mPass: String): List<User>

    @Query("SELECT * FROM Menu")
    fun getAllMenu(): List<Menu>

    @Query("SELECT * FROM Transaksi")
    fun getAllTransaksi(): List<Transaksi>

    @Query("SELECT * FROM Meja")
    fun getAllMeja(): List<Meja>

    @Query("SELECT * FROM User")
    fun getAllUser(): List<User>

    @Query("SELECT * FROM DetailTransaksi WHERE id_transaksi = :idTransaksi")
    fun getDetailTransaksifromTransaksi(idTransaksi: Int): List<DetailTransaksi>

    @Query("SELECT * FROM Menu WHERE jenis = :jenisMenu")
    fun getMenuFilterJenis(jenisMenu: String): List<Menu>
    @Delete
    fun deleteMenu(menu: Menu)

    @Query("UPDATE Menu SET nama_menu = :namaMenu, jenis = :Jenis, harga = :Harga WHERE id_menu = :id")
    fun updateMenu(namaMenu: String, Jenis: String, Harga: Int, id: Int)

    @Query("SELECT * FROM Menu WHERE id_menu = :Id")
    fun getMenu(Id: Int): Menu

    @Query("UPDATE Meja SET nomor_meja = :namaMeja WHERE id_meja = :id")
    fun updateMeja(namaMeja: String, id: Int)

    @Delete
    fun deleteMeja(meja: Meja)

    @Query("SELECT nomor_meja FROM Meja")
    fun getAllNamaMeja(): List<String>

    @Query("SELECT id_meja FROM Meja WHERE nomor_meja = :namaMeja")
    fun getIdMejaFromNama(namaMeja: String): Int

    @Query("SELECT id_transaksi FROM Transaksi WHERE tgl_transaksi = :tglTransaksi AND id_user = :idUser AND id_meja = :idMeja AND nama_pelanggan = :namaPelanggan AND status = :Status")
    fun getIdTransaksiFromOther(tglTransaksi: String, idUser: Int, idMeja: Int, namaPelanggan: String, Status:String):Int

    @Delete
    fun deleteUser(user: User)

    @Query("UPDATE User SET nama = :nama, email = :email, password = :password, role = :role WHERE id_user = :id")
    fun updateUser(nama: String, email: String, password: String,role : String , id: Int)

    @Query("SELECT * FROM User WHERE id_user = :Id")
    fun getUser(Id: Int): User
}