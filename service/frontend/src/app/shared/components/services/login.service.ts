/*import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';

@Injectable({
    providedIn: 'root'
})
export class LoginService {
    private subject = new Subject();

    logar(usuario: Usuario) {
        localStorage.setItem('usuario', usuario);
        this.subject.next(usuario)
    }

    usuarioLogado(): Usuario {



    }

    logout() {

    }

    verificarLogin(): Subject {
        return this.subject;
    }
}*/
