package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Usuario;
import com.basis.sge.service.servico.dto.UsuarioDTO;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-01-15T12:45:05-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toDto(UsuarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setNome( dto.getNome() );
        usuario.setEmail( dto.getEmail() );
        usuario.setTelefone( dto.getTelefone() );
        if ( dto.getDataNascimento() != null ) {
            usuario.setDataNascimento( Date.from( dto.getDataNascimento().atStartOfDay( ZoneOffset.UTC ).toInstant() ) );
        }

        return usuario;
    }

    @Override
    public UsuarioDTO toEntity(Usuario entity) {
        if ( entity == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setNome( entity.getNome() );
        if ( entity.getDataNascimento() != null ) {
            usuarioDTO.setDataNascimento( LocalDateTime.ofInstant( entity.getDataNascimento().toInstant(), ZoneOffset.UTC ).toLocalDate() );
        }
        usuarioDTO.setTelefone( entity.getTelefone() );
        usuarioDTO.setEmail( entity.getEmail() );

        return usuarioDTO;
    }

    @Override
    public List<Usuario> toDto(List<UsuarioDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Usuario> list = new ArrayList<Usuario>( dtoList.size() );
        for ( UsuarioDTO usuarioDTO : dtoList ) {
            list.add( toDto( usuarioDTO ) );
        }

        return list;
    }

    @Override
    public List<UsuarioDTO> toEntity(List<Usuario> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UsuarioDTO> list = new ArrayList<UsuarioDTO>( entityList.size() );
        for ( Usuario usuario : entityList ) {
            list.add( toEntity( usuario ) );
        }

        return list;
    }
}
