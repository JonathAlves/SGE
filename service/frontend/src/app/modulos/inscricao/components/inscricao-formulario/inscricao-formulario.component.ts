import { Evento } from 'src/app/dominios/evento';
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Inscricao } from "src/app/dominios/inscricao";
import { InscricaoService } from './../../servicos/inscricao.service';
import { Usuario } from 'src/app/dominios/usuario';

@Component({
  selector: 'app-inscricao-formulario',
  templateUrl: './inscricao-formulario.component.html',
  styleUrls: ['./inscricao-formulario.component.css']
})
export class InscricaoFormularioComponent implements OnInit {

  formInscricao: FormGroup;
  inscricao = new Inscricao;


  constructor(
    private fb: FormBuilder,
    private inscricaoService: InscricaoService,
    private route: ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.formInscricao = this.fb.group({
        resposta1: this.inscricao.respostas[0],
        resposta2: this.inscricao.respostas[1],
        resposta3: this.inscricao.respostas[2],
        resposta4: this.inscricao.respostas[3]
    })

  }

}
