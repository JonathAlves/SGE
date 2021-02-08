package com.basis.sge.service.servico.mapper;

import com.basis.sge.service.dominio.Usuario;
import com.basis.sge.service.servico.dto.UsuarioDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-02-07T00:10:43-0300",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_275 (Private Build)"
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
        usuario.setChave( dto.getChave() );
        usuario.setAdmin( dto.getAdmin() );

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
        usuarioDTO.setChave( entity.getChave() );
        usuarioDTO.setAdmin( entity.getAdmin() );

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
