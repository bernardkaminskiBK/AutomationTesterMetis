package listeners;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.util.Optional;

public class Listener implements TestWatcher {

    @Override
    public void testDisabled(ExtensionContext context, Optional<String> reason) {
        System.out.println("------------------------------------------------------");
        System.out.println("Tento test bol zablokovany: " + context.getTestMethod().get() + ", dovod: " + reason.get());
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        System.out.println("------------------------------------------------------");
        System.out.println("Tento test zbehol uspesne: " + context.getTestMethod().get());
    }

    @Override
    public void testAborted(ExtensionContext context, Throwable cause) {
        System.out.println("------------------------------------------------------");
        System.out.println("Tento test bol preruseny: " + context.getTestMethod().get() + ", dovod: " + cause.getMessage());
    }

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        System.out.println("------------------------------------------------------");
        System.out.println("Tento test sa nepodarilo: " + context.getTestMethod().get() + ", dovod: " + cause.getMessage());
    }

}
