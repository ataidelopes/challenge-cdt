package common.mapper;

import java.util.Optional;
import java.util.function.Consumer;

public final class PatchMapper {

    public static <T> void changeIfPresentValue(T nullable, Consumer<T> consumer){
        Optional.ofNullable(nullable).ifPresent(e -> consumer.accept(e));
    }
}
