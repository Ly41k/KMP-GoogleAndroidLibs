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
        Dashboard, Home, More
    }

    enum class Home {
        HomeFlow, Home, Details
    }

    enum class More {
        MoreFlow, More, Settings
    }
}
