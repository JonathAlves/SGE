import { NgModule } from '@angular/core';
import { CardComponent } from './components/card/card.component';
import { PRIMENG_IMPORTS } from './primeng-imports';
import { ConfirmationService } from 'primeng';
import { UsuarioService } from './components/services/usuario.service';
import { FormularioComponent } from './components/formulario/formulario.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';



@NgModule({
    declarations: [
        CardComponent,
        FormularioComponent,  
    ],
    imports: [
        PRIMENG_IMPORTS,
        FormsModule,
        ReactiveFormsModule 
    ],
    providers: [
        ConfirmationService,
        UsuarioService,
            
    ],
    exports: [
        PRIMENG_IMPORTS,
        CardComponent,
        FormularioComponent,
    ]
})
export class SharedModule { }
