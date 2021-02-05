import { PerguntaEvento } from "./pergunta-evento";

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

    perguntas: PerguntaEvento[] = [];

    constructor() {}
}