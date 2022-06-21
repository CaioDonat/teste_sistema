<?php

namespace App\Http\Controllers;

use App\Http\Requests\StoreProgramacaoRequest;
use App\Http\Requests\UpdateProgramacaoRequest;
use App\Models\Programacao;
use DB;

class ProgramacaoController extends Controller{
    public function index(){
        return Programacao::all();
    }
    public function movie_list(){
        return DB::table('programacaos')
        ->select('id_programacao', 'movie_name')
        ->get();
    }
    public function store(StoreProgramacaoRequest $request){
        $programacao = new Programacao();
        $programacao->movie_name = $request->input('movie_name');
        $programacao->parental_rating = $request->input('parental_rating');
        $programacao->size_room = $request->input('size_room');

        //$parental_rating

        if($programacao->save() ){
            return $programacao->toJson(JSON_PRETTY_PRINT);
        }
        return json_encode(["erro"=>true]);
    }
}
