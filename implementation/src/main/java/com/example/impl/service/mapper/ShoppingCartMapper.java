package com.example.impl.service.mapper;

import com.example.impl.entity.ShoppingCart;
import com.example.impl.service.model.Request;
import com.example.impl.service.model.Response;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ShoppingCartMapper {

    static Response entityToResponse(ShoppingCart entity) {
        return Mappers.getMapper(ShoppingCartMapper.class).map(entity);
    }

    static ShoppingCart requestToEntity(Request request) {
        return Mappers.getMapper(ShoppingCartMapper.class).map(request);
    }

    static Response RequestToResponse(Request request){
        return Mappers.getMapper(ShoppingCartMapper.class).mapper(request);
    }

    ShoppingCart map(Request request);

    Response map(ShoppingCart entity);

    Response mapper(Request quest);

}
