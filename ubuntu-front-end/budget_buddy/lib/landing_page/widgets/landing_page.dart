import 'dart:ui';

import 'package:budget_buddy/accounts/accounts_carousal.dart';
import 'package:budget_buddy/budgets/budget_carousal.dart';
import 'package:budget_buddy/budgets/budget_carousal_alternate.dart';
import 'package:budget_buddy/landing_page/widgets/landing_page_graph_component.dart';
import 'package:budget_buddy/landing_page/widgets/news_feed.dart';
import 'package:budget_buddy/landing_page/widgets/news_feed_budget_card.dart';
import 'package:flutter/material.dart';

class LandingPage extends StatefulWidget {
  const LandingPage({super.key});

  @override
  State<LandingPage> createState() => _LandingPageState();
}

class _LandingPageState extends State<LandingPage> {
  @override
  Widget build(BuildContext context) {
    double bottomScrollerHeight = MediaQuery.of(context).size.height;

    return Stack(
      alignment: Alignment.topCenter,
      children: [
        const LandingPageGraphComponent(),
        const Positioned(
            top: 255.0, left: 0.0, right: 0.0, child: BudgetList()),
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
                            Container(
                              height: 70,
                              width: MediaQuery.of(context).size.width * 0.1,
                              child: const Center(
                                child: Icon(
                                  Icons.menu_rounded,
                                  color: Colors.white,
                                ),
                              ),
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
                            //The middle section containing the news feed and search
                            //functionality for budgets and groups
                            Container(
                              height: MediaQuery.of(context).size.height * 0.3,
                              width: MediaQuery.of(context).size.width * 0.95,
                              decoration: const BoxDecoration(
                                color: Colors.transparent,
                              ),
                              child: Row(
                                mainAxisAlignment:
                                    MainAxisAlignment.spaceEvenly,
                                children: [
                                  Container(
                                    width: MediaQuery.of(context).size.width *
                                        0.45,
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
                                  //Budget search widget
                                  Container(
                                      width: MediaQuery.of(context).size.width *
                                          0.45,
                                      color: Colors.white,
                                      child: const NewsFeedBudgetCard())
                                ],
                              ),
                            ),
                            //Bottom section to hold the chat history
                            Padding(
                              padding: const EdgeInsets.all(8.0),
                              child: Container(
                                height:
                                    MediaQuery.of(context).size.height * 0.3,
                                width: MediaQuery.of(context).size.width * 0.95,
                                decoration: BoxDecoration(
                                  color: Colors.white,
                                ),
                              ),
                            )
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

// return Column(
//       mainAxisAlignment: MainAxisAlignment.start,
//       crossAxisAlignment: CrossAxisAlignment.stretch,
//       children: [
//         const SizedBox(
//           height: 5.0,
//         ),
//         const LandingPageGraphComponent(),
//         const Padding(
//           padding: EdgeInsets.fromLTRB(8.0, 0, 0, 0),
//           child: Row(
//             mainAxisAlignment: MainAxisAlignment.start,
//             children: [
//               Text("My Budgets"),
//             ],
//           ),
//         ),
//         const BudgetCarousal(),
//         const AccountCarousal(),
//         SizedBox(
//           height: MediaQuery.of(context).size.height,
//           child: DraggableScrollableSheet(builder: (context, scrollController) {
//             return Container(
//               height: 10,
//               color: Colors.amber,
//             );
//           }),
//         )
//       ],
//     );

// return Container(
    //   height: MediaQuery.of(context).size.height,
    //   width: MediaQuery.of(context).size.width,
    //   child: CustomScrollView(
    //     slivers: [
    //       SliverList(
    //           delegate: SliverChildListDelegate([
    //         const LandingPageGraphComponent(),
    //         Container(
    //           height: 300,
    //           color: Colors.amber,
    //         ),
    //         Container(
    //           height: 300,
    //           color: Colors.red,
    //         )
    //       ]))
    //     ],
    //   ),
    // );

