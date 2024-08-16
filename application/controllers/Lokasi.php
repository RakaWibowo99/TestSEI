<?php
defined('BASEPATH') or exit('No direct script access allowed');

class Lokasi extends CI_Controller
{
    public function __construct()
    {
        parent::__construct();
        $this->load->model('Lokasi_model');
    }

    public function index()
    {
        $data['lokasi'] = $this->Lokasi_model->get_all_lokasi();
        $this->load->view('lokasi/index', $data);
    }

    public function create()
    {
        if ($_SERVER['REQUEST_METHOD'] == 'POST') {
            $data = array(
                'nama_lokasi' => $this->input->post('nama_lokasi'),
                'negara' => $this->input->post('negara'),
                'provinsi' => $this->input->post('provinsi'),
                'kota' => $this->input->post('kota')
            );

            $this->Lokasi_model->create_lokasi($data);
            redirect('lokasi');
        } else {
            $this->load->view('lokasi/create');
        }
    }

    public function edit($id)
    {
        if ($_SERVER['REQUEST_METHOD'] == 'PUT') {
            $data = array(
                'nama_lokasi' => $this->input->post('nama_lokasi'),
                'negara' => $this->input->post('negara'),
                'provinsi' => $this->input->post('provinsi'),
                'kota' => $this->input->post('kota')
            );

            $this->Lokasi_model->update_lokasi($id, $data);
            redirect('lokasi');
        } else {
            $data['lokasi'] = $this->Lokasi_model->get_lokasi($id);
            $this->load->view('lokasi/edit', $data);
        }
    }

    public function delete($id)
    {
        $this->Lokasi_model->delete_lokasi($id);
        redirect('lokasi');
    }
}
?>
