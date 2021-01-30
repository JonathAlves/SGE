import { Evento } from "./evento";
import { EventoPerguntaId } from "./evento-pergunta-id";
import { Pergunta } from "./pergunta";

export class EventoPergunta{
    eventoPerguntaId: EventoPerguntaId;
    evento: Evento;
    pergunta: Pergunta;
}