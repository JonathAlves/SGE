import { InscricaoResposta } from "./inscricao-resposta";

export class Inscricao{
    idEvento: number;
    idUsuario: number;
    idTipoSituacao: number;
    respostas: InscricaoResposta[] = [];
}