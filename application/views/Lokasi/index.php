<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List Lokasi</title>
</head>
<body>
    <h1>List Lokasi</h1>
    <a href="<?php echo site_url('lokasi/create'); ?>">Tambah Lokasi Baru</a>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nama Lokasi</th>
                <th>Negara</th>
                <th>Aksi</th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($lokasi as $item): ?>
            <tr>
                <td><?php echo $item['id']; ?></td>
                <td><?php echo $item['nama_lokasi']; ?></td>
                <td><?php echo $item['negara']; ?></td>
                <td>
                    <a href="<?php echo site_url('lokasi/edit/'.$item['id']); ?>">Edit</a> |
                    <a href="<?php echo site_url('lokasi/delete/'.$item['id']); ?>">Hapus</a>
                </td>
            </tr>
            <?php endforeach; ?>
        </tbody>
    </table>
</body>
</html>
