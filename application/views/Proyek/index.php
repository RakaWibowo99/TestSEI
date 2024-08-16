<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List Proyek</title>
</head>
<body>
    <h1>List Proyek</h1>
    <a href="<?php echo site_url('proyek/create'); ?>">Tambah Proyek Baru</a>
    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Nama Proyek</th>
                <th>Client</th>
                <th>Aksi</th>
            </tr>
        </thead>
        <tbody>
            <?php foreach ($proyek as $item): ?>
            <tr>
                <td><?php echo $item['id']; ?></td>
                <td><?php echo $item['nama_proyek']; ?></td>
                <td><?php echo $item['client']; ?></td>
                <td>
                    <a href="<?php echo site_url('proyek/edit/'.$item['id']); ?>">Edit</a> |
                    <a href="<?php echo site_url('proyek/delete/'.$item['id']); ?>">Hapus</a>
                </td>
            </tr>
            <?php endforeach; ?>
        </tbody>
    </table>
</body>
</html>
