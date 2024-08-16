<?php
defined('BASEPATH') or exit('No direct script access allowed');

class Lokasi_model extends CI_Model
{
    private $api_url = 'http://localhost:8080/lokasi';

    public function get_all_lokasi()
    {
        $response = $this->restclient->get($this->api_url);
        return json_decode($response, true);
    }

    public function create_lokasi($data)
    {
        $response = $this->restclient->post($this->api_url, $data);
        return json_decode($response, true);
    }

    public function update_lokasi($id, $data)
    {
        $response = $this->restclient->put($this->api_url . '/' . $id, $data);
        return json_decode($response, true);
    }

    public function delete_lokasi($id)
    {
        $response = $this->restclient->delete($this->api_url . '/' . $id);
        return json_decode($response, true);
    }
}
?>
