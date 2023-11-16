import 'package:budget_buddy/pages/budgets/budget_page/budget_page.dart';
import 'package:budget_buddy/pages/budgets/create_budget_page/create_budget_page.dart';
import 'package:budget_buddy/config/scroll_behaviour.dart';
import 'package:budget_buddy/pages/landing_page/widgets/landing_page.dart';
import 'package:budget_buddy/theme.dart';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

void main() {
  runApp(const ProviderScope(child: MyApp()));
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      // routerDelegate: _router.routerDelegate,
      // routeInformationParser: _router.routeInformationParser,
      // routeInformationProvider: _router.routeInformationProvider,
      theme: customTheme,
      scrollBehavior: MyCustomScrollBehavior(),
      debugShowCheckedModeBanner: false,
      home: const MyHomePage(title: 'Budget Buddy'),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});

  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {
  int currentTab = 0;

  void _selectPage(int index) {
    setState(() {
      currentTab = index;
    });
  }

  @override
  Widget build(BuildContext context) {
    Widget activePage = const LandingPage();

    if (currentTab == 1) {
      activePage = const BudgetPage();
    }

    if (currentTab == 2) {
      activePage = const CreateBudgetPage();
    }

    // This method is rerun every time setState is called, for instance as done
    // by the _incrementCounter method above.
    //
    // The Flutter framework has been optimized to make rerunning build methods
    // fast, so that you can just rebuild anything that needs updating rather
    // than having to individually change instances of widgets.
    return Scaffold(
        appBar: AppBar(
          flexibleSpace: Container(
            decoration: const BoxDecoration(
              gradient: LinearGradient(
                  colors: [Colors.amber, Colors.amber],
                  begin: FractionalOffset(0.0, 0.0),
                  end: FractionalOffset(1.0, 0.0),
                  stops: [0.0, 1.0],
                  tileMode: TileMode.clamp),
            ),
          ),
          backgroundColor: Theme.of(context).colorScheme.inversePrimary,
          title: Text(widget.title),
          elevation: 50,
        ),
        body: activePage,
        //floatingActionButtonLocation: FloatingActionButtonLocation.centerDocked,
        // floatingActionButton: const FloatingActionButton(
        //   onPressed: null,
        //   child: Icon(Icons.add),
        // ),
        bottomNavigationBar: BottomNavigationBar(
          fixedColor: Colors.amber,
          currentIndex: currentTab,
          onTap: _selectPage,
          //     (value) {
          //   switch (value) {
          //     case 0:
          //       context.go('/');
          //       break;
          //     case 1:
          //       context.go('/budgets');
          //       break;
          //     case 2:
          //       context.go('/accounts');
          //       break;
          //   }
          // },
          items: const <BottomNavigationBarItem>[
            BottomNavigationBarItem(
              icon: Icon(Icons.home),
              label: 'Home',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.person),
              label: 'Budgets',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.account_balance),
              label: 'Accounts',
            ),
            BottomNavigationBarItem(
              icon: Icon(Icons.newspaper),
              label: 'Financial News',
            ),
          ],
        ));
  }
}

// final GoRouter _router = GoRouter(routes: <GoRoute>[
//   GoRoute(
//       path: '/',
//       builder: (BuildContext context, GoRouterState state) {
//         return const MyHomePage(title: 'Budget Buddy');
//       }),
//   GoRoute(
//       path: '/budgets',
//       builder: (BuildContext context, GoRouterState state) {
//         return const BudgetPage();
//       }),
//   GoRoute(
//       path: '/accounts',
//       builder: (BuildContext context, GoRouterState state) {
//         return const AccountPage();
//       })
// ]);
