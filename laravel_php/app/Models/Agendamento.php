<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Agendamento extends Model
{
    use HasFactory;
    protected $table = 'agendamentos';
    protected $primaryKey = 'id_agendamentos';
    public $timestamps = false;
}
