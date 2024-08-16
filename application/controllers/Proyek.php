<?php
defined('BASEPATH') or exit('No direct script access allowed');

class Proyek extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        $this->load->model('Proyek_model');
    }

    public function index()
    {
        $data['proyek'] = $this->Proyek_model->get_all_proyek();
        $this->load->view('proyek/index', $data);
    }

    public function create()
    {
        if ($_SERVER['REQUEST_METHOD'] == 'POST') {
            $data = array(
                'nama_proyek' => $this->input->post('nama_proyek'),
                'client' => $this->input->post('client'),
                'tgl_mulai' => $this->input->post('tgl_mulai'),
                'tgl_selesai' => $this->input->post('tgl_selesai'),
                'pimpinan_proyek' => $this->input->post('pimpinan_proyek'),
                'keterangan' => $this->input->post('keterangan')
            );

            $this->Proyek_model->create_proyek($data);
            redirect('proyek');
        } else {
            $this->load->view('proyek/create');
        }
    }

    public function edit($id)
    {
        if ($_SERVER['REQUEST_METHOD'] == 'PUT') {
            $data = array(
                'nama_proyek' => $this->input->post('nama_proyek'),
                'client' => $this->input->post('client'),
                'tgl_mulai' => $this->input->post('tgl_mulai'),
                'tgl_selesai' => $this->input->post('tgl_selesai'),
                'pimpinan_proyek' => $this->input->post('pimpinan_proyek'),
                'keterangan' => $this->input->post('keterangan')
            );

            $this->Proyek_model->update_proyek($id, $data);
            redirect('proyek');
        } else {
            $data['proyek'] = $this->Proyek_model->get_proyek($id);
            $this->load->view('proyek/edit', $data);
        }
    }

    public function delete($id)
    {
        $this->Proyek_model->delete_proyek($id);
        redirect('proyek');
    }
}
?>
