package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Usuario;
import com.basis.sge.service.servico.dto.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
<<<<<<< HEAD
    date = "2021-01-21T15:07:40-0300",
=======
    date = "2021-01-20T15:48:02-0300",
>>>>>>> 0fa98efb43e19289c6f62be56eb3651962aa84f8
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toEntity(UsuarioDTO arg0) {
        if ( arg0 == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( arg0.getId() );
        usuario.setNome( arg0.getNome() );
        usuario.setCpf( arg0.getCpf() );
        usuario.setEmail( arg0.getEmail() );
        usuario.setTelefone( arg0.getTelefone() );
        usuario.setDataNascimento( arg0.getDataNascimento() );

        return usuario;
    }

    @Override
    public UsuarioDTO toDto(Usuario arg0) {
        if ( arg0 == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId( arg0.getId() );
        usuarioDTO.setCpf( arg0.getCpf() );
        usuarioDTO.setNome( arg0.getNome() );
        usuarioDTO.setDataNascimento( arg0.getDataNascimento() );
        usuarioDTO.setTelefone( arg0.getTelefone() );
        usuarioDTO.setEmail( arg0.getEmail() );

        return usuarioDTO;
    }

    @Override
    public List<Usuario> toEntity(List<UsuarioDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Usuario> list = new ArrayList<Usuario>( arg0.size() );
        for ( UsuarioDTO usuarioDTO : arg0 ) {
            list.add( toEntity( usuarioDTO ) );
        }

        return list;
    }

    @Override
    public List<UsuarioDTO> toDto(List<Usuario> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<UsuarioDTO> list = new ArrayList<UsuarioDTO>( arg0.size() );
        for ( Usuario usuario : arg0 ) {
            list.add( toDto( usuario ) );
        }

        return list;
    }
}
