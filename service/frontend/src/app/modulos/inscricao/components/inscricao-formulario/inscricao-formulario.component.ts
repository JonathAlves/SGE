import { Evento } from 'src/app/dominios/evento';
import { Usuario } from 'src/app/dominios/usuario';
import { HttpErrorResponse } from '@angular/common/http';
import { ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Inscricao } from "src/app/dominios/inscricao";
import { InscricaoService } from './../../servicos/inscricao.service';


@Component({
  selector: 'app-inscricao-formulario',
  templateUrl: './inscricao-formulario.component.html',
  styleUrls: ['./inscricao-formulario.component.css']
})
export class InscricaoFormularioComponent implements OnInit {
  
  @Input() usuario = new Usuario();
  @Input() evento = new Evento();
  @Input() inscricaoSalva = new EventEmitter<Inscricao>();
 
  formInscricao: FormGroup;
  inscricao = new Inscricao;

  constructor(
    private fb: FormBuilder,
    private inscricaoService: InscricaoService,
    private route: ActivatedRoute,  
  ) {}

  ngOnInit(): void {
    this.inscrever();
  }
  
  inscrever(){
    this.route.params.subscribe(params => {
      if (params.id) {
      }
    });
    this.inscricao.id = Math.random();
    this.inscricao.idEvento = this.evento.id
    this.inscricao.idUsuario = this.usuario.id;
    this.inscricao.idTipoSituacao = 1;
    
    
    this.formInscricao = this.fb.group({
      resposta1: '',
    }) 
  }

  salvar() {
    if (this.formInscricao.invalid) {
      alert('Formulário inválido');
      return;
    } else {
      this.inscricaoService.salvarInscricao(this.inscricao)
        .subscribe(inscricao => {
          alert('Inscricao salva!');
          this.fecharDialog(inscricao);
        }, (erro: HttpErrorResponse) => {
          alert(erro.error.message);
        });
    }
  }

  fecharDialog(inscricaoSalva: Inscricao) {
    this.inscricaoSalva.emit(inscricaoSalva);
  }
}