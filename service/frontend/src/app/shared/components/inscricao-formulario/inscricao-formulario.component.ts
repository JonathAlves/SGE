import { HttpErrorResponse } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Evento } from 'src/app/dominios/evento';
import { Inscricao } from "src/app/dominios/inscricao";
import { Usuario } from 'src/app/dominios/usuario';
import { InscricaoService } from '../../../modulos/inscricao/servicos/inscricao.service';
import { ListagemComponent } from './../../../modulos/evento/components/listagem/listagem.component';
import { EventoService } from './../../../modulos/evento/services/evento.service';
import { ListagemInformacoesComponent } from './../../../modulos/minha-conta/components/listagem-informacoes/listagem-informacoes.component';
import { UsuarioService } from './../services/usuario.service';


@Component({
  selector: 'app-inscricao-formulario',
  templateUrl: './inscricao-formulario.component.html',
  styleUrls: ['./inscricao-formulario.component.css']
})
export class InscricaoFormularioComponent implements OnInit {
  
  @Input() usuario = new Usuario();
  @Input() evento = new Evento();
  @Input() inscricaoSalva = new EventEmitter<Inscricao>();
  @Input() inscricao = new Inscricao;

  formInscricao: FormGroup;
  
  usuarios: Usuario
  eventoService: EventoService
  usuarioService: UsuarioService;

  constructor(
    private fb: FormBuilder,
    private inscricaoService: InscricaoService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    this.inscrever();
  }
  
  inscrever(){
    const usuarioLocal: Usuario = JSON.parse(window.localStorage.getItem("usuario"));
    console.log('Id usuario', usuarioLocal.id);
    this.inscricao.idUsuario = usuarioLocal.id
    this.inscricao.idTipoSituacao = 1;  //valor padrão de aguardando aprovação
   
    this.route.params.subscribe(params => {
      if(params.id){
        this.buscarEvento(params.id);
      }
    });    
    
  }
 
  buscarEvento(id: number) {
    this.eventoService.buscarEventoPorId(id)
      .subscribe(evento => {
        this.evento = evento
        console.log('id Evento', this.evento.id)
      }); 
  }

  salvar() {
      this.inscricaoService.salvarInscricao(this.inscricao)
        .subscribe(inscricao => {
          alert('Inscricao salva!');
        }, (erro: HttpErrorResponse) => {
          alert(erro.error.message);
        });
    }
}

