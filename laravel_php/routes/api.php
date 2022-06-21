<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\AgendamentoController as Agendamento;
use App\Http\Controllers\ProgramacaoController as Programacao;

Route::middleware('auth:sanctum')->get('/user', function (Request $request) {
    return $request->user();
});

//Agendamentos
Route::get('/agendamentos', [Agendamento::class, 'index']);
Route::post('/agendamentos', [Agendamento::class, 'store']);
Route::get('/drop', [Agendamento::class, 'dropDB']);
Route::get('/agendamentos/per_movie/{id_movie}', [Agendamento::class, 'perMovie']);

//Programacao
    //GET
Route::get('/programacaos', [Programacao::class, 'index']);
Route::get('/programacaos/movie_list', [Programacao::class, 'movie_list']);
Route::get('/programacaos/movie_list_name', [Programacao::class, 'movie_list_name']);

    //POST
Route::post('/programacaos', [Programacao::class, 'store']);



