import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Usuario } from 'src/app/dominios/usuario';

@Injectable()
export class UsuarioService {
  url = `${environment.apiUrl}/usuarios`;

  constructor( private  http: HttpClient) { }

  getUsuarios(): Observable<Usuario[]>{
    return this.http.get<Usuario[]> (`${this.url}`);


  }




  }

