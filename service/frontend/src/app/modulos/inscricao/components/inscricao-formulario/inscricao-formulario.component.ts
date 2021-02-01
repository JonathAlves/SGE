import { Evento } from 'src/app/dominios/evento';
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { Inscricao } from "src/app/dominios/inscricao";
import { InscricaoService } from './../../servicos/inscricao.service';


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

    })  
  }
  salvar(){
    if (this.formInscricao.invalid) {
      alert('Formulário inválido');
      return;
    }

      this.inscricaoService.salvarInscricao(this.inscricao)
      .subscribe(inscricao => {
        console.log('inscricao salva', inscricao);
        alert('Inscrição Salva!')
      }, (erro: HttpErrorResponse) => {
        alert(erro.error.message);
      });
    }
  }

