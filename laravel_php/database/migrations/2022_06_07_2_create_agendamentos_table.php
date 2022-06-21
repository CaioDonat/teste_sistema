<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateAgendamentosTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('agendamentos', function (Blueprint $table) {
            $table->increments('id_agendamento');
            $table->string('people_name');
            $table->integer('age_people');
            $table->unsignedInteger('id_programacao');

            //$table->foreignId('id_programacao')->constrained('programacaos');
            $table->foreign('id_programacao')->references('id_programacao')->on('programacaos');


        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('agendamentos');
    }
}
