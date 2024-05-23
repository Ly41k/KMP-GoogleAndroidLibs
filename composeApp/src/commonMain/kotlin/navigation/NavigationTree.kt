package navigation

object NavigationTree {

    enum class Splash {
        SplashFlow, Splash
    }

    enum class Onboarding {
        OnboardingFlow, Onboarding
    }

    enum class Auth {
        AuthFlow, Login, Register, Forgot
    }

    enum class Main {
        Dashboard, Home, Order, Orders, More
    }

    enum class Home {
        HomeFlow, Home
    }

    enum class More {
        MoreFlow, More
    }

    enum class Orders {
        OrdersFlow, Orders
    }

    enum class Order {
        OrderFlow, OrderMainInfo, OrderServices, OrderAdditionalInfo, OrderFile, OrderPreview
    }
}
