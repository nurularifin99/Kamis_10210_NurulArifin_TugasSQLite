package com.udinus.kamis_10210_nurularifin_tugassqlite;

public class MahasiswaModel {
    private String nim, nama, tanggal_lahir, jenis_kelamin, alamat, kota;
    public MahasiswaModel() {
    }

    public MahasiswaModel(String nim, String nama, String tanggal_lahir, String jenis_kelamin, String alamat, String kota) {
        this.nim = nim;
        this.nama = nama;
        this.tanggal_lahir = tanggal_lahir;
        this.jenis_kelamin = jenis_kelamin;
        this.alamat = alamat;
        this.kota = kota;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }
}