<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tambah Lokasi Baru</title>
</head>
<body>
    <h1>Tambah Lokasi Baru</h1>
    <form action="<?php echo site_url('lokasi/create'); ?>" method="POST">
        <label for="nama_lokasi">Nama Lokasi:</label>
        <input type="text" name="nama_lokasi" required>
        <br>
        <label for="negara">Negara:</label>
        <input type="text" name="negara" required>
        <br>
        <label for="provinsi">Provinsi:</label>
        <input type="text" name="provinsi" required>
        <br>
        <label for="kota">Kota:</label>
        <input type="text" name="kota" required>
        <br>
        <button type="submit">Simpan</button>
    </form>
</body>
</html>
