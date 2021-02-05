import { InscricaoResposta } from "./inscricao-resposta";

export class Inscricao{
    id: number;
    idEvento: number;
    idUsuario: number;
    idTipoSituacao: number;
    respostas: InscricaoResposta[] = [];
}