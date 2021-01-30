import { EventoPergunta } from "./evento-pergunta";

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

    perguntas: EventoPergunta[] = [];

    constructor() {}
}