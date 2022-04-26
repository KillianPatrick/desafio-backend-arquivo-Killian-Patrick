//package helper;
//
//import Exception.ErrorCodeEnum;
//import lombok.RequiredArgsConstructor;
//
//import java.util.Locale;
//
//@RequiredArgsConstructor
//public class MessageHelper {
//
//    private final MessageSource messageSource;
//
//    private MessageSourceAccessor accessor;
//
//    public void init() {
//        accessor = new MessageSourceAccessor(messageSource, Locale.getDefault());
//    }
//
//    public String get(ErrorCodeEnum code, Object... args) {
//        return accessor.getMessage(code.getMessageKey(), args);
//    }
//
//}
