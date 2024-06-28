package com.example.marketplace.mapper;

import java.util.List;

public interface CommonMapper <D,E>{
    D toDTO(E e);
    E toENTITY(D d);
    List<D> toDTOs(List<E> es);
    List<E> toENTOTies(List<D> ds);
}
