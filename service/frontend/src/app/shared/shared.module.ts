import { NgModule } from '@angular/core';
import { CardComponent } from './components/card/card.component';
import { PRIMENG_IMPORTS } from './primeng-imports';

@NgModule({
    declarations: [
        CardComponent
    ],
    imports: [
        PRIMENG_IMPORTS,
    ],
    providers: [],
    exports: [
        PRIMENG_IMPORTS,
        CardComponent
    ]
})
export class SharedModule { }
