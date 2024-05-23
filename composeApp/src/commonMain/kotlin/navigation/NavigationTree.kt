package navigation

object NavigationTree {

    enum class Splash {
        Splash
    }

    enum class Auth {
        AuthFlow, Login, Register, Forgot
    }

    enum class Main {
        Dashboard, HomeFlow, MoreFlow
    }

    enum class Home {
        Home, Details
    }

    enum class More {
        More, Settings
    }
}
