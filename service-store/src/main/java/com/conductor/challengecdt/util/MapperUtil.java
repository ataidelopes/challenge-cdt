package com.conductor.challengecdt.util;

import ma.glasnost.orika.MapperFacade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class MapperUtil<T> {
    /**
     * Metodo para converter um MapperFacade um lista
     * @param mapper Mapa
     * @param source Lista
     * @param destType Classe generica da lista
     * @return Lista
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static <T> List<T> map(final MapperFacade mapper, final List source, final Class destType) {
        if (mapper == null || source == null) {
            return null;
        }
        List dest = new ArrayList();
        dest.addAll(mapper.mapAsList(source, destType));
        return dest;
    }

    /**
     * Metodo para converter um MapperFacade em um Objeto
     * @param mapper Mapa
     * @param obj Objeto
     * @param destType Classe generica da lista
     * @return Objeto convertido
     */
    @SuppressWarnings({ "rawtypes"})
    public static <T> T map(MapperFacade mapper, Object obj, Class destType) {
        List<Object> listMap = map(mapper, Arrays.asList(obj), destType);
        return Objects.isNull(listMap) || listMap.isEmpty() ? null : (T) listMap.get(0);
    }
}
