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
    date = "2021-01-29T14:01:45-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
=======
<<<<<<< HEAD
    date = "2021-01-25T14:33:28-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.9.1 (Ubuntu)"
=======
    date = "2021-01-28T22:37:04-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
>>>>>>> 62b7406a3988ee19d1ca6f30df7fe966aca0ad16
>>>>>>> 31c54247e79c9a0dcf0253f8994cf6aaeb289717
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toEntity(UsuarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setId( dto.getId() );
        usuario.setNome( dto.getNome() );
        usuario.setCpf( dto.getCpf() );
        usuario.setEmail( dto.getEmail() );
        usuario.setTelefone( dto.getTelefone() );
        usuario.setDataNascimento( dto.getDataNascimento() );

        return usuario;
    }

    @Override
    public UsuarioDTO toDto(Usuario entity) {
        if ( entity == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId( entity.getId() );
        usuarioDTO.setCpf( entity.getCpf() );
        usuarioDTO.setNome( entity.getNome() );
        usuarioDTO.setDataNascimento( entity.getDataNascimento() );
        usuarioDTO.setTelefone( entity.getTelefone() );
        usuarioDTO.setEmail( entity.getEmail() );

        return usuarioDTO;
    }

    @Override
    public List<Usuario> toEntity(List<UsuarioDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Usuario> list = new ArrayList<Usuario>( dtoList.size() );
        for ( UsuarioDTO usuarioDTO : dtoList ) {
            list.add( toEntity( usuarioDTO ) );
        }

        return list;
    }

    @Override
    public List<UsuarioDTO> toDto(List<Usuario> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<UsuarioDTO> list = new ArrayList<UsuarioDTO>( entityList.size() );
        for ( Usuario usuario : entityList ) {
            list.add( toDto( usuario ) );
        }

        return list;
    }
}
