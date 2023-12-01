import 'dart:js_interop';

import 'package:animations/animations.dart';
import 'package:budget_buddy/data_providers/budgetDataProvider.dart';
import 'package:budget_buddy/models/budget.dart';
import 'package:budget_buddy/pages/budgets/budget_carousal_alternate.dart';
import 'package:budget_buddy/pages/landing_page/widgets/landing_page_graph_component.dart';
import 'package:budget_buddy/pages/landing_page/widgets/news_feed.dart';
import 'package:budget_buddy/pages/landing_page/widgets/news_feed_budget_card.dart';
import 'package:budget_buddy/services/budgetService.dart';
import 'package:budget_buddy/utils/discover_news.dart';
import 'package:flutter/material.dart';
import 'package:flutter_riverpod/flutter_riverpod.dart';

import '../../budgets/create_budget_page/create_budget_page.dart';

class LandingPage extends ConsumerWidget {
  const LandingPage({super.key});

  void getRecommendedBudgets() {}

  void getNewsSnippets() {}

  @override
  Widget build(BuildContext context, WidgetRef ref) {
    final data = ref.watch(budgetDataProvider);

    List<Budget> _budgetList = [];
    double bottomScrollerHeight = MediaQuery.of(context).size.height;

    return Stack(
      alignment: Alignment.topCenter,
      children: [
        //Top area showing graphs regarding budgets
        const LandingPageGraphComponent(),
        //Middle section displaying the current budgets
        Positioned(
            top: 255.0,
            left: 0.0,
            right: 0.0,
            child: data.when(
                data: (data) {
                  List<Budget> budgetList = data.map((e) => e).toList();
                  _budgetList = budgetList;
                  return BudgetList(
                    budgetList: budgetList,
                  );
                },
                error: (err, s) => Text(err.toString()),
                loading: () => const Center(
                      child: CircularProgressIndicator(),
                    ))),
        const Positioned(
          top: 255.0,
          left: 0.0,
          right: 0.0,
          child: Padding(
            padding: EdgeInsets.symmetric(horizontal: 15.0),
            child: Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: [
                Text(
                  'Budgets',
                  style: TextStyle(
                      fontSize: 18.0,
                      fontWeight: FontWeight.bold,
                      fontFamily: 'Calibre-Semibold',
                      letterSpacing: 1.0),
                ),
                Text(
                  'See All',
                  style: TextStyle(
                      color: Colors.blue,
                      fontWeight: FontWeight.bold,
                      fontFamily: 'Calibre-Semibold',
                      fontSize: 12.0),
                )
              ],
            ),
          ),
        ),
        //The scrollable feed section
        DraggableScrollableSheet(
            initialChildSize: 0.17,
            minChildSize: 0.17,
            maxChildSize: 1.0,
            builder: (context, scrollController) {
              return Container(
                  decoration: BoxDecoration(
                      color: Colors.grey[300],
                      borderRadius: const BorderRadius.only(
                          topLeft: Radius.circular(30.0),
                          topRight: Radius.circular(30.0))),
                  height: bottomScrollerHeight,
                  child: ListView(
                    controller: scrollController,
                    children: [
                      Padding(
                        padding: const EdgeInsets.all(8.0),
                        child: Row(
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            Container(
                              height: 4,
                              width: MediaQuery.of(context).size.width * 0.15,
                              decoration: BoxDecoration(
                                  color: Colors.white70,
                                  borderRadius: BorderRadius.circular(17),
                                  boxShadow: [
                                    BoxShadow(
                                        blurRadius: 8,
                                        color: Colors.black.withOpacity(0.5),
                                        offset: const Offset(0, 7)),
                                  ]),
                            )
                          ],
                        ),
                      ),
                      // The Account Tile row
                      Padding(
                        padding: const EdgeInsets.fromLTRB(8.0, 5.0, 0, 0),
                        child: Row(
                          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                          children: [
                            Container(
                              height: 70,
                              width: 70,
                              decoration: BoxDecoration(
                                  image: const DecorationImage(
                                      opacity: 0.9,
                                      fit: BoxFit.cover,
                                      image: AssetImage(
                                          "/images/background_image_1.jpg")),
                                  borderRadius: BorderRadius.circular(17),
                                  boxShadow: [
                                    BoxShadow(
                                        blurRadius: 8,
                                        color: Colors.black.withOpacity(0.5),
                                        offset: const Offset(0, 7)),
                                  ]),
                              child: const Stack(
                                children: [
                                  Positioned.fill(
                                    top: 49,
                                    left: 41,
                                    child: Padding(
                                      padding: EdgeInsets.all(3.0),
                                      child: Text(
                                        'ABSA',
                                        style: TextStyle(
                                            fontSize: 8,
                                            color: Colors.white,
                                            fontWeight: FontWeight.bold),
                                      ),
                                    ),
                                  )
                                ],
                              ),
                            ),
                            Container(
                              height: 70,
                              width: 70,
                              decoration: BoxDecoration(
                                  image: const DecorationImage(
                                      opacity: 0.9,
                                      fit: BoxFit.cover,
                                      image: AssetImage(
                                          "/images/background_image_1.jpg")),
                                  borderRadius: BorderRadius.circular(17),
                                  boxShadow: [
                                    BoxShadow(
                                        blurRadius: 8,
                                        color: Colors.black.withOpacity(0.5),
                                        offset: const Offset(0, 7)),
                                  ]),
                            ),
                            Container(
                              height: 70,
                              width: 70,
                              decoration: BoxDecoration(
                                  image: const DecorationImage(
                                      opacity: 0.9,
                                      fit: BoxFit.cover,
                                      image: AssetImage(
                                          "/images/background_image_1.jpg")),
                                  borderRadius: BorderRadius.circular(17),
                                  boxShadow: [
                                    BoxShadow(
                                        blurRadius: 8,
                                        color: Colors.black.withOpacity(0.5),
                                        offset: const Offset(0, 7)),
                                  ]),
                            ),
                            Container(
                              height: 70,
                              width: 70,
                              decoration: BoxDecoration(
                                  image: const DecorationImage(
                                      opacity: 0.9,
                                      fit: BoxFit.cover,
                                      image: AssetImage(
                                          "/images/background_image_1.jpg")),
                                  borderRadius: BorderRadius.circular(17),
                                  boxShadow: [
                                    BoxShadow(
                                        blurRadius: 8,
                                        color: Colors.black.withOpacity(0.5),
                                        offset: const Offset(0, 7)),
                                  ]),
                            ),
                            //The floating action button to create a budget
                            OpenContainer<Budget>(
                              onClosed: (budget) {
                                _budgetList.add(budget as Budget);
                                // BudgetService().addToBudgets(budget);
                                //TODO: Need to implement riverpod state provider to update the budget list
                                for (var element in _budgetList) {
                                  print(element.toString());
                                }
                              },
                              transitionDuration: const Duration(seconds: 1),
                              openBuilder: (context, action) {
                                return const CreateBudgetPage();
                              },
                              closedBuilder: (BuildContext context,
                                  void Function() action) {
                                return Container(
                                    height: 50,
                                    width: 50,
                                    decoration: BoxDecoration(
                                      borderRadius: BorderRadius.circular(20),
                                    ),
                                    child: const Icon(
                                      Icons.add_outlined,
                                      size: 30,
                                    ));
                              },
                            )
                          ],
                        ),
                      ),
                      const SizedBox(
                        height: 20,
                      ),
                      const Divider(
                        thickness: 1,
                        color: Colors.white,
                        indent: 30,
                        endIndent: 30,
                      ),
                      Padding(
                        padding: const EdgeInsets.all(8.0),
                        child: Column(
                          mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                          crossAxisAlignment: CrossAxisAlignment.start,
                          children: [
                            //The Sub title and seach bar
                            const Padding(
                              padding: EdgeInsets.symmetric(
                                  horizontal: 12.0, vertical: 8.0),
                              child: Text(
                                "Discover",
                                style: TextStyle(
                                    //fontStyle: ,
                                    letterSpacing: 1.3,
                                    color: Colors.black,
                                    fontSize: 20.0,
                                    fontWeight: FontWeight.bold),
                              ),
                            ),
                            const DiscoverNews(),
                            //The middle section containing the news feed
                            Container(
                              height: MediaQuery.of(context).size.height * 0.3,
                              width: MediaQuery.of(context).size.width * 0.95,
                              decoration: const BoxDecoration(
                                color: Colors.transparent,
                              ),
                              child: Container(
                                margin:
                                    const EdgeInsets.symmetric(horizontal: 2.0),
                                width: MediaQuery.of(context).size.width * 0.95,
                                child: ShaderMask(
                                  shaderCallback: (rect) {
                                    return const LinearGradient(
                                      begin: Alignment.topCenter,
                                      end: Alignment.bottomCenter,
                                      colors: [
                                        Colors.transparent,
                                        Colors.white
                                      ],
                                      stops: [0.7, 1.0],
                                    ).createShader(rect);
                                  },
                                  blendMode: BlendMode.dstOut,
                                  child: const NewsFeed(),
                                ),
                              ),
                            ),
                            //Bottom section to hold the chat history
                            Padding(
                                padding: const EdgeInsets.all(8.0),
                                child: //Budget search widget
                                    Container(
                                        width:
                                            MediaQuery.of(context).size.width *
                                                0.45,
                                        color: Colors.transparent,
                                        child: const NewsFeedBudgetCard()))
                          ],
                        ),
                      )
                    ],
                  ));
            })
      ],
    );
  }
}
