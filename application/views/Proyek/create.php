<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Tambah Proyek Baru</title>
</head>
<body>
    <h1>Tambah Proyek Baru</h1>
    <form action="<?php echo site_url('proyek/create'); ?>" method="POST">
        <label for="nama_proyek">Nama Proyek:</label>
        <input type="text" name="nama_proyek" required>
        <br>
        <label for="client">Client:</label>
        <input type="text" name="client" required>
        <br>
        <label for="tgl_mulai">Tanggal Mulai:</label>
        <input type="date" name="tgl_mulai" required>
        <br>
        <label for="tgl_selesai">Tanggal Selesai:</label>
        <input type="date" name="tgl_selesai" required>
        <br>
        <label for="pimpinan_proyek">Pimpinan Proyek:</label>
        <input type="text" name="pimpinan_proyek" required>
        <br>
        <label for="keterangan">Keterangan:</label>
        <textarea name="keterangan" required></textarea>
        <br>
        <button type="submit">Simpan</button>
    </form>
</body>
</html>
