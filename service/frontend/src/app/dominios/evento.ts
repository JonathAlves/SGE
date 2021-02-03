<<<<<<< HEAD
import { EventoPergunta } from "./evento-pergunta";
=======
import { PerguntaEvento } from "./pergunta-evento";
>>>>>>> 70d1d01d9bfe10fb41c74cea2aff0e0478d6921d

export class Evento {
    id: number;

    titulo: string;

    dataInicio: string;

    dataTermino: string;

    descricao: string

    qtVagas: number;

    valor: number;

    local: string;

    tipoInscricao: boolean;

    idTipoEvento: number;

<<<<<<< HEAD
    perguntas: EventoPergunta[] = [];
=======
    perguntas: PerguntaEvento[] = [];
>>>>>>> 70d1d01d9bfe10fb41c74cea2aff0e0478d6921d

    constructor() {}
}