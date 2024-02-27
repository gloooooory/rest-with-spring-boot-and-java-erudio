package br.com.erudio.mapper;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {
    private static final Mapper mapper = new DozerBeanMapper();

    public static <O, D> D parseObject(O origin, Class<D> destination) {
        return mapper.map(origin, destination);
    }

    public static <O, D> List<D> parseListObjects(List<O> origin, Class<D> destination) {
        List<D> destinationObjects = new ArrayList<>();

        for (O o : origin) {
            destinationObjects.add(mapper.map(o, destination));
        }

        return destinationObjects;
    }
}
