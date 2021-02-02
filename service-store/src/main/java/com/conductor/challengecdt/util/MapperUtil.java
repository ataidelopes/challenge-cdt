package com.conductor.challengecdt.util;

import com.conductor.challengecdt.controller.dto.StoreDto;
import com.conductor.challengecdt.model.Store;
import com.conductor.challengecdt.util.exceptions.BusinessRulesExceptions;
import ma.glasnost.orika.MapperFacade;

import java.util.*;

public class MapperUtil<T> {
    /**
     * Metodo para converter um MapperFacade um lista
     *
     * @param mapper   Mapa
     * @param source   Lista
     * @param destType Classe generica da lista
     * @return Lista
     */
    @SuppressWarnings({"rawtypes", "unchecked"})
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
     *
     * @param mapper   Mapa
     * @param obj      Objeto
     * @param destType Classe generica da lista
     * @return Objeto convertido
     */
    @SuppressWarnings({"rawtypes"})
    public static <T> T map(MapperFacade mapper, Object obj, Class destType) {
        Object objNonNullable = validateOfNullabe(obj);
        List<Object> listMap = map(mapper, Arrays.asList(objNonNullable), destType);
        return Objects.isNull(listMap) || listMap.isEmpty() ? null : (T) listMap.get(0);
    }

    private static Object validateOfNullabe(Object obj) {
        return Optional.ofNullable(obj).orElseThrow(() -> new BusinessRulesExceptions("object cannot be null"));
    }

}
