<?php

namespace App\Http\Controllers;

use App\Http\Requests\StoreAgendamentoRequest;
use App\Http\Requests\UpdateAgendamentoRequest;
use App\Http\Controllers\Controller;
use App\Models\Agendamento as Agendamento;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Redis;

use Illuminate\Support\Facades\DB;


class AgendamentoController extends Controller{
    
    public function index(){
        return Agendamento::all();
    }
    
    public function store(StoreAgendamentoRequest $request){
        $agendamento = new Agendamento();
        $agendamento->people_name = $request->input('people_name');
        $agendamento->age_people = $request->input('age_people');
        $agendamento->id_programacao = $request->input('id_programacao');

        $movie_parental_rating = DB::table('programacaos')
        ->where('id_programacao', $agendamento->id_programacao)
        ->value('parental_rating');

        if($agendamento->age_people < $movie_parental_rating){
            return json_encode(["retorno"=>"não atingil idade minima",$movie_parental_rating ]);
        }

        if($agendamento->save()){
            return json_encode(["retorno"=>"Salvo com sucesso"]);
        }
        return json_encode(["retorno"=>true]);
    }

    public function perMovie($id_movie)
    {
        $agendamentos = DB::table('agendamentos')
        ->select('people_name')
        ->where('id_programacao', $id_movie)
        ->get();
        
        return json_encode($agendamentos, JSON_PRETTY_PRINT);
    }
}
