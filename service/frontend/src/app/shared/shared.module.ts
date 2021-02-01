import { NgModule } from '@angular/core';
import { CardComponent } from './components/card/card.component';
import { PRIMENG_IMPORTS } from './primeng-imports';
import { ConfirmationService } from 'primeng';

@NgModule({
    declarations: [
        CardComponent
    ],
    imports: [
        PRIMENG_IMPORTS,
    ],
    providers: [
        ConfirmationService
    ],
    exports: [
        PRIMENG_IMPORTS,
        CardComponent,
    
    ]
})
export class SharedModule { }
