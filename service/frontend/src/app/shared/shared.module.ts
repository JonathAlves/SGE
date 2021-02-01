import { NgModule } from '@angular/core';
import { ConfirmationService } from 'primeng';
import { CardComponent } from './components/card/card.component';
import { PRIMENG_IMPORTS } from './primeng-imports';

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
        CardComponent
    ]
})
export class SharedModule { }
