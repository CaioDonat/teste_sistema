<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Programacao extends Model
{
    use HasFactory;
    protected $table = 'programacaos';
    protected $primaryKey = 'id_programacao';
    public $timestamps = false;
}
