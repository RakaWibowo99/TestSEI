<?php
defined('BASEPATH') or exit('No direct script access allowed');

class Proyek_model extends CI_Model
{
    private $api_url = 'http://localhost:8080/proyek';

    public function get_all_proyek()
    {
        $response = $this->restclient->get($this->api_url);
        return json_decode($response, true);
    }

    public function create_proyek($data)
    {
        $response = $this->restclient->post($this->api_url, $data);
        return json_decode($response, true);
    }

    public function update_proyek($id, $data)
    {
        $response = $this->restclient->put($this->api_url . '/' . $id, $data);
        return json_decode($response, true);
    }

    public function delete_proyek($id)
    {
        $response = $this->restclient->delete($this->api_url . '/' . $id);
        return json_decode($response, true);
    }
}
?>
