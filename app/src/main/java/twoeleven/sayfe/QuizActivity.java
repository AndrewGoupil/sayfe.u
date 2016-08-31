package twoeleven.sayfe;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.SpannableString;
import android.text.method.ScrollingMovementMethod;
import android.text.style.AlignmentSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

public class QuizActivity extends AppCompatActivity {

    Integer currentQuestion = 0;
    String[] questions = {"Asher and Dylan have been dating for 7 months and Asher has keys to," +
            " and often sleeps at Dylan’s apartment because Dylan lives much closer to campus. " +
            "Asher arrives at Dylan’s apartment while Dylan is still in class and Asher proceeds " +
            "to fall asleep. Dylan comes home from class, and climbs into the bed that Asher is" +
            " sleeping in, waking up him up. Now awake, Asher and Dylan begin kissing.\n\n",

            "Sheelah and Ramona have been dating for 6 months. Ramona has an injury that flares " +
                    "up during physical activity and sometimes during sex; one night Sheelah notices " +
                    "Ramona wincing in pain and tells her that she can stop if it hurts too much. " +
                    "Ramona shakes her head, says “it’s ok,” and continues touching " +
                    "Sheelah.\n\n",

            "Daanish and Leanne are lab partners in class. After completing a very difficult " +
                    "midterm, Leanne suggest that the two go out to celebrate. They decide to go to a " +
                    "local dance club. At first, they are dancing at distance from one another, but at " +
                    "some point, Leanne moves closer and begins grinding with Daanish. Daanish " +
                    "reciprocates and the two spend the next few hours grinding with one another.\n\n",

            "Deirdre and Rhys meet at a party in Rhys’ residence and the two hit it off and " +
                    "spend the night flirting. Dierdre and Rhys are both drinking heavily, but Dierdre," +
                    " who recently finished a really difficult midterm is celebrating with shots and " +
                    "quickly becomes very intoxicated. She suggests that the two go back to Rhys’ room," +
                    " to which he agrees, but once there, he realizes how drunk she is, and suggests" +
                    " she lay down in his bed, and try to sleep it off. Deirdre passes out almost " +
                    "immediately, and Rhys grabs a spare blanket, and crashes on his couch. When " +
                    "Dierdre wakes up in the morning, she has no idea what has happened and freaks out " +
                    "at Rhys, thinking that something might have happened while she was blacked out.\n\n",

            "Yael and Daniel have been friends since high school but their friends have recently" +
                    " begun commenting on how it seems like they like each other. One night, Yael is " +
                    "studying at home when she gets a call from Daniel, who is at a bar with friends, " +
                    "asking if he can come over. When she agrees, he tells her he just broke up with " +
                    "his long-term girlfriend; he is clearly a little drunk and seems upset. While they" +
                    " cuddle on her bed, Daniel puts his hand inside her jeans and she moves closer to " +
                    "him as he fingers her.\n\n",

            "Greg and Calum have been dating for seven months and haven’t had sex yet, because" +
                    " Greg wants them to get tested for STIs and STDs first. Calum’s tests come back " +
                    "clean, but Greg finds out that he has herpes. Greg and Calum talk about the " +
                    "results of the tests and Greg tells Calum that he has herpes, and that Calum could" +
                    " get it too if they don’t take some precautions. Calum decides that despite this " +
                    "risk, he still wants to have unprotected sex with Greg.\n\n",

            "Sivan and Yotam have been friends since frosh week. Sivan has always had a crush " +
                    "on Yotam, and while the two always seemed to be flirting, nothing romantic has " +
                    "ever happened because Yotam is in a long term relationship with his partner, Noa." +
                    " One night, while Yotam and Sivan are studying together, Yotam kisses Sivan. She " +
                    "kisses him back and the two proceeded to sleep together. When they woke up the" +
                    " next morning, Yotam was upset, because he had jeopardized his relationship with" +
                    " Noa.\n\n",

            "Idan and Shira are in the same program and have a lot of classes together. They " +
                    "study together a lot at the library and occasionally fool around afterwards. One" +
                    " time, while the two are at the library, Idan starts rubbing Shira’s leg. She " +
                    "moves closer and he begins fingering her. Shira moves even closer and begins " +
                    "rubbing Idan’s leg.\n\n",

            "Pia is a first year student who has cerebral palsy and uses crutches to get around." +
                    " She is still unfamiliar with the school, and sometimes has problems accessing her" +
                    " classrooms. Pia is running late for a class and doesn't have time to find the " +
                    "elevator in the building, so she attempts to climb the stairs. While she is making" +
                    " her way up the stairs, another student sees her and offers to help. Pia declines," +
                    " but the boy insists, picking her up and groping her in the process. Pia yells for " +
                    "the man to put her down, but he tells her he is helping and carries her up the " +
                    "stairs against her wishes.\n\n",

            "Laine is a fourth year student who lives on campus. She has no feeling below the" +
                    " waist and uses a wheelchair to get around. She has recently started seeing a Doug," +
                    " who sometimes sleeps over in her room in res. One night, Doug is sleeping over " +
                    "and want’s to have sex, but Laine is tiered, and doesn’t want to. Doug tries to " +
                    "convince Laine to have sex anyways, because she won’t even feel purely vaginal" +
                    " intercourse, and so he insists it’s not a big deal. Laine again declines and the" +
                    " two go to sleep, but Laine wakes up to discover that Doug has been touching her" +
                    " while she was asleep.\n\n",

            "Dev and Ian are at a party together and have been dancing together and flirting" +
                    " all night. Both are drinking a lot, but Ian is much smaller than Dev and quickly" +
                    " gets drunk. He is having trouble standing up straight, and starts slurring his" +
                    " words. Dev suggests that the two go to his room, where they can take it easy," +
                    " and sober up. In his room, Dev and Ian start kissing, and after a while, Dev" +
                    " goes to get a condom. When he returns, Ian has his eyes closed. Dev tries to wake" +
                    " him up by kissing his neck and touching him. Ian does not wake up, but Declan" +
                    " continues to touch him.\n\n",

            "Molly and Chloe are friends from class, and Molly invites Chloe over one day after " +
                    "class to watch a movie. When Chloe arrives, Molly and Chloe begin fooling around." +
                    " Chloe tells Molly she wants to go down on her, and asks if Molly has a dental " +
                    "dam. Molly says she does not, but assures Chloe that she doesn't need to use one," +
                    " because Molly has recently been tested and has no STIs and STDs. Chloe tells " +
                    "Molly that she isn’t comfortable going down on her without protections. Molly gets " +
                    "frustrated and tells Chloe to either go down on her or to leave. Chloe performs" +
                    " oral sex on Molly because she doesn’t want to ruin their relationship, but she is" +
                    " uncomfortable and spends the next few weeks concerned that she might have " +
                    "contracted an STI or STD.\n\n",

            "James and Jesse have been together since frosh week and now, in third year, James" +
                    " has decided to go on exchange to Europe for the semester. A few nights before " +
                    "James leaves, while James and Jesse are having sex, James takes out his phone and" +
                    " starts taking picture of the two of them. Jesse tells him to put his phone away " +
                    "and delete the photos. James doesn't listen and says ‘you let me see you naked all " +
                    "the time, I don’t understand what the big deal is.’\n\n",

            "Daya and Jamar have hooked up both times this month their group of friends has " +
                    "gone out. While pre-drinking for a Halloween party, she asks if she can sleep over" +
                    " in his room again, and he agrees. However, because the parties they go to have " +
                    "free beer, he gets more drunk than he expected, and back at his room he wants to" +
                    " fall straight to sleep. Daya is not as drunk as he is and begins unzipping his " +
                    "pants. When he says he just wants to sleep, she asks why he doesn’t want her to go" +
                    " down on him, asking what is wrong with him.\n\n",

            "Heather and Ryan are on a first date at a restaurant near campus. They are having" +
                    " a great time, but Ryan isn’t sure he’s interested in pursuing Heather romantically." +
                    " After they finish dinner, Heather asks Ryan if he wants to come back to her " +
                    "apartment with her. He says no, citing an early meeting the next day, and avoids " +
                    "eye contact. Heather agrees and instead begins walking Ryan back to his building" +
                    " on campus. Ryan explains to Heather that she doesn’t have to walk with him, her " +
                    "apartment is in the other direction, but she insists. While walking back, Heather" +
                    " reaches to hold Ryan’s hand. He moves it away from hers, so she moves closer and" +
                    " tries to hold his hand again. They arrive at Ryan’s building and Heather offers " +
                    "to walk Ryan to his door, but he declines. Ryan tries to give Heather a hug, but " +
                    "Heather moves, kissing Ryan. Ryan takes a step back away from Heather, but Heather" +
                    " steps closer, kissing him again.\n\n",

            "Alex and Heather are at a party playing beer pong. Heather is not very good at the" +
                    " game, so she gets drunk very quickly. After the game, Heather takes a few shots " +
                    "with her friends. She sits down next to Alex because she is too drunk to stand " +
                    "straight, and he leans in to kiss her. She leans away from him but doesn’t have " +
                    "the energy to move away and eventually lets him kiss her.\n\n",

            "Noor and Niall are introduced by mutual friends while the group is out for drinks." +
                    " Noor drinks more wine than she usually would and when everyone is starting to " +
                    "plan how to get home, she starts stumbling towards the door. Niall notices and " +
                    "insists she go home with him instead of trying to walk back to her own house. " +
                    "They hold hands back to his house and at a few points he leans it to kiss her but" +
                    " she turns her head and keeps talking.\n\n",

            "Klea and Arman meet at a mutual friend’s party and spend the evening drinking and" +
                    " flirting with one another. They decide to go back to Klea’s room, and the two " +
                    "begin having sex. Klea starts to feel very intoxicated and is having trouble " +
                    "staying awake while they are having sex. Klea tells Arman that maybe they should " +
                    "stop because she is too drunk and can’t stay awake, but Arman keeps going, saying" +
                    " that he is almost finished, and that she should wait until he is done.\n\n",

            "Kyle is at a party in his residence when he notices that a first year that he has" +
                    " been eyeing, Carla, has entered the room with her friends; they noticeably smell" +
                    " like weed and immediately go to refill their cups with the very strong punch." +
                    " Kyle goes up to Carla and starts talking to her. She is smiling but her words" +
                    " are slurred and she seems out of it. After she leans in and kisses him, they go" +
                    " to his room. While they make out she tries to unzip her jeans to take them off," +
                    " but can’t do it and gives up, lying back on his bed with her eyes closed. He " +
                    "unbuttons them for her and begins fingering her while her eyes are still closed;" +
                    " she mumbles something but her words are slurred and he can’t tell what she is" +
                    " saying.\n\n",

            "Aarav is a new employee at a bakery in town, owned by a married couple. When Aarav" +
                    " is working and the wife is not around, Robert, the husband, touches him " +
                    "uncomfortably, such as rubbing his back, and makes comments about his physical" +
                    " appearance.\n\n",

            "Khalil is a frosh leader and his friend Matt introduces him to Sandra, who is in" +
                    " Matt’s frosh group and comes from the same town as Khalil. The third night of " +
                    "frosh week, he invites her to his room to smoke weed later. When they are both " +
                    "high they talk about past relationships and she reveals that she has never had " +
                    "sex, while he says he slept with “a lot of girls” in first year. He kisses her " +
                    "and they start making out. Khalil asks Sandra if he can go down on her; she " +
                    "hesitates and says she isn’t sure. Khalil starts kissing her stomach and says " +
                    "“trust me, you’ll love it”, and when Sandra says again that she isn’t sure, he " +
                    "tells her to trust him because he has done this before.\n\n",

            "Jing is a fourth year student and is in the process of applying to graduate " +
                    "school. She needs a professor to write her a letter of recommendation and so she" +
                    " approaches one of her instructors from first semester. She asks her professor to" +
                    " meet with her and he agrees to do so, but only over drinks. Jing decides to meet" +
                    " with him, but while having drinks the professor makes comments about Jing’s " +
                    "appearance that make her feel uncomfortable. He at times places his hand on her" +
                    " knee or touches her arm across the table. While he agrees to write her the " +
                    "letter after their meeting, he asks her if she would like to go out with him " +
                    "again. She agrees to do so because she is afraid that if she does not, he will " +
                    "not write the letter she needs from him.\n\n",

            "Noah’s teacher says she is looking for a student from class to help her with her" +
                    " research. Noah is interested in applying and goes to his teacher’s office after " +
                    "class to talk to her about it. When he gets there, she invites Noah to sit down," +
                    " placing her hand on his back. She sits very close to Noah, who tries to move " +
                    "away, but she keeps inching her chair closer to his. While Noah tries to ask her" +
                    " questions about the research position, she continues to turn the conversation " +
                    "towards him, specifically his dating history and sexual experiences. A lot of " +
                    "her questions make Noah feel uncomfortable, but he really needs some research " +
                    "experience for his resume so he remains in her office answering her questions.\n\n",

            "It’s the first day of Frosh week, and Asha is nervous about transitioning into " +
                    "university life; she comes from a small town and has strict parents, and never " +
                    "drank in high school. Her frosh leader, Isaac, is very friendly towards her. " +
                    "During a party he invites her to drink with his group of friends in his room, " +
                    "and she accepts since she is underage and can’t drink at frosh events. However, " +
                    "it turns out that his friends aren’t in his room. Once they get there he starts " +
                    "talking about how she is smart for befriending an upper year; there is wine on " +
                    "his shelf but he doesn’t offer it to her and instead starts touching her, putting" +
                    " his hand down her shorts. When she seems hesitant, he keeps touching her while" +
                    " saying they can go back to the party together and that he can introduce her to" +
                    " upper years.\n\n",

            "Alejandra and Juan have been friends since frosh week. As they watch a movie he " +
                    "kisses her and after making out for a while, they move to his bedroom. Juan " +
                    "leaves the room to get a condom and while he is gone Alejandra starts thinking " +
                    "about what this would do to their friendship. When Juan returns and begins " +
                    "kissing Alejandra, she tells him she thinks this is a bad idea and tries to " +
                    "squirm out from underneath him, which he ignores.\n\n",

            "Peter and Kai have been dating for 6 months but Kai has never had sex before and" +
                    " is scared. They decide to do it for the first time on Kai’s birthday, but that " +
                    "night, when they begin having sex, Kai is in pain because they are nervous. Kai " +
                    "suggests that they wait and try again another time. Peter ignores this and says " +
                    "the pain will get better soon.\n\n",

            "Anton and Cathy were floormates in first year and have been sleeping together for" +
                    " over a year. Cathy takes birth control pills but because the two are not " +
                    "exclusive, they still use condoms regularly while having sex to protect " +
                    "themselves against STIs and STDs. Anton is sometimes frustrated by their use of " +
                    "condoms and often asks Cathy if she will have sex with him without one, to which " +
                    "she always says no. One night, while the two are having sex, Anton removes the " +
                    "condom without informing Cathy.\n\n",

            "Geoff and Iris meet on Tinder and begin chatting. The two discuss meeting up to " +
                    "have sex and agree on a time and location to meet. The two meet and begin kissing," +
                    " but Iris is put off by how aggressive Geoff is being, and she begins to feel" +
                    " uncomfortable. She changes her mind about wanting to have sex, but when she " +
                    "tries to leave, Geoff pulls her back to him and begins touching her under her " +
                    "clothes, saying that this must be what she wanted to have happen.\n\n",

            "Marieke and Shad have been sleeping together for about a month, and often try " +
                    "new things in bed. One night, while they are having sex, Shad initates anal sex" +
                    " with Marike. She tells him to stop, and they go back to having vaginal " +
                    "intercourse. A few minutes later, Shad does it again.\n\n",

            "Amiri and Luke are on their first date together at a concert. Part way through a" +
                    " song Luke moves in closer and starts grinding on Amiri. She moves forward " +
                    "slightly, putting distance between her and him, and turns her head away when he " +
                    "tries to kiss her.\n\n",

            "Ally and Erin have 3 classes together and are both execs in the same club, so " +
                    "they have begun spending a lot of time together and are close friends. Ally has" +
                    " feelings for Erin, but she is not sure if Erin feels the same way. One day, " +
                    "Erin invites Ally to sleep over, and Ally thinks this is Erin expressing feelings" +
                    " for Ally. Ally and Erin spend the evening hanging out, and when it is time to go" +
                    " to sleep, Ally grabs Erin’s face and kisses her; Erin doesn’t move and gets " +
                    "upset with Ally afterwards\n\n",

            "Aaron and Haruki meet while out for dinner with a big group of mutual friends. " +
                    "They chat for the majority of the evening and at the end of the night Aaron asks" +
                    " Haruki if he wants to go back to his place to see his record collection. Haruki" +
                    " agrees, but upon arriving at his house Aaron almost immediately begins trying " +
                    "to undress him. Haruki didn’t really expect this and he says that he should get " +
                    "home because it’s late. Aaron ignores this and playfully pushes Haruki onto the " +
                    "bed; Haruki is still surprised that this is happening and, not knowing what to " +
                    "do, continues kissing Aaron while Aaron unbuckles his belt.\n\n",

            "Brad and Ursula have gone out on two dates, but Ursula is not sure if she’s " +
                    "interested in Brad. For their third date, Brad invites Ursula over to his house" +
                    " to watch a movie, and she agrees. During the movie, they sit about a foot apart." +
                    " During the movie, Brad moves closer to Ursula putting his hand on her leg. " +
                    "Ursula moves away, all the way to the edge of the couch, and Brad moves to follow" +
                    " her, placing his hand higher up her thigh this time. Ursula, feeling very " +
                    "uncomfortable, moves to sit on the floor, and Bradley moves so he is sitting " +
                    "behind her and begins rubbing her back and neck.\n\n",

            "Emmanuel and Tamara have been dating for a couple months but haven’t slept " +
                    "together because Tamara’s conservative family is against sex before marriage and" +
                    " she doesn’t want to disrespect them. Emmanuel continually asks her when she " +
                    "will be ready to have sex, even though she has already explained her reasoning to" +
                    " him many times, and one night he tells her that if she doesn’t at least go down" +
                    " on him, he will break up with her. She tries to argue for a minute and then " +
                    "begrudgingly agrees.\n\n",

            "Deja is hanging out with a group of new friends from her residence floor in one " +
                    "of their rooms. Tyler, who has a habit of making girls on the floor uncomfortable" +
                    " with his sexual comments and is generally considered “creepy”, enters the room " +
                    "and tells her to pretend he is Emil, her long-distance boyfriend. He sits right " +
                    "beside her and puts his hand on her leg while she laughs uncomfortably and looks" +
                    " at her phone.\n\n",

            "Yuna and Sofia are dating and they go with a group of friends to a frat party. " +
                    "While Sofia is talking to someone from her class, Yuna goes to get a drink, and" +
                    " a boy comes up and starts flirting with her at the bar, introducing himself as" +
                    " Chris. She lets him buy her a drink and he asks if she has a boyfriend. When " +
                    "she explains that she is dating a girl, Chris says that he doesn’t believe her " +
                    "and begins asking her personal questions about her sexuality and her relationship." +
                    " When she refuses to answer, he says she is lying to him and moves closer while " +
                    "her back is against the wall. He gets close and whispers in her ear that he can" +
                    " “make her turn straight”, listing out things that he would like do to her, while" +
                    " she tries to see where Sofia is.\n\n",

            "Hana is walking to class and in passing a group of boys start commenting on the " +
                    "length of her skirt, saying she looks “slutty” today.\n\n",

            "Dylan is a computer science student and is often the only girl in her classes and" +
                    " tutorials. In one tutorial, the instructor often makes her feel very " +
                    "uncomfortable, by making lewd comments about her body, and joking around with the" +
                    " students about hooking up with girls, singling her out while doing so. Although" +
                    " attendance at her tutorials is mandatory, Dylan regularly skips class because " +
                    "she doesn’t feel comfortable.\n\n",

            "Aisha is really happy with how she has changed over first year. She loves how fit" +
                    " she feels thanks to joining the varsity soccer team, and living in a big city " +
                    "has given her more options for clothing stores compared to her small hometown. " +
                    "She hasn’t updated her profile picture all year, and when she finally does so at " +
                    "the end of the year, some of the friends she made during frosh week message her " +
                    "about her new picture, commenting on her physical appearance and saying things " +
                    "such as ‘looking really hot, Aisha, wish I had thought to tap that during frosh " +
                    "week’ or ‘where was this outfit back in september.’ Aisha feels very upset and " +
                    "starts to feel uncomfortable about the changes she has made this year, and in " +
                    "the end, changes her profile picture to an old family photo.\n\n",

            "Wyatt and Eli have been together for four years. Last month, Eli was sexually " +
                    "assaulted while at a party on campus. At first, Wyatt was very supportive of Eli," +
                    " helping her navigate her options, and supporting her decision not to report to " +
                    "police, even though he was very angry about what happened. Eli has started to " +
                    "feel better, but has expressed that she does not like it when Wyatt touches her," +
                    " and she has not wanted to be intimate since the incident. One night, Wyatt, who" +
                    " has started to grow impatient, tells Eli that is she can’t get over what " +
                    "happened, he doesn’t want to be with her anymore. After saying this, Wyatt kisses" +
                    " Eli, who doesn’t make any effort to reciprocate, and afterwards quickly comes up" +
                    " with a reason that she has to leave.\n\n",

            "Susan and Valeria have been dating for 4 years and moved into an off-campus " +
                    "apartment together for third year. Susan gets home from an evening class one " +
                    "night and decides to go to bed. Later on, Valeria comes into the room and lies " +
                    "close to Susan, kissing her neck. Susan first says she is tired but lets Valeria" +
                    " keep kissing and touching her.\n\n",

            "Simon and Katya have been dating for 2 years and usually have sex several nights" +
                    " a week when she stays at his house. One night, she is tired and falls asleep " +
                    "right away instead. She wakes up to find his hand reaching into her pyjama pants," +
                    " and he ignores her attempts at moving his hand.\n\n",

            "Jared and Eliana have been together for 6 years and live together while Eliana is" +
                    " finishing 4th year. Eliana is spending a lot of time at the library, but decides" +
                    " to take the night off to go out with Jared. Jared gets very drunk and wants to " +
                    "go straight to sleep when they arrive home. Eliana has been too busy to be " +
                    "intimate with Jared for a few weeks wants to have sex. While Jared is lying in " +
                    "bed, half asleep, Eliana climbs on top of him, grinding her body against his and" +
                    " starting to remove his shirt. Jared tells her to stop, and that he is too tired," +
                    " and feeling sick from all the alcohol, but Eliana ignores him. She begins kissing" +
                    " his neck, assuring him she will do all the work, while she continuing to undress" +
                    " him.\n\n",

            "Silpa and Fitz were dating for three years and recently broke up during a heated" +
                    " argument about the way he acts around her friends. They have kept talking since" +
                    " but aren’t officially back together. Fitz is very outgoing and loud, while Silpa" +
                    " is a lot more shy and reserved and less open to public displays of affection. " +
                    "At a party with some friends, Fitz, who has been drinking, comes up to Silpa, " +
                    "hugging her from behind. She stiffens up, feeling uncomfortable and tries to " +
                    "squirm away from Fitz. Fitz ignores this and begins kissing Silpa’s neck.\n\n"
    };

    String[] answers = {"Consent: Even though Asher was sleeping before, he is now awake and " +
            "actively participating in this interaction.\n\n",

            "Consent: even though she is in pain, Ramona is an active participant and wants to " +
                    "have sex with Sheelah. This is a boundary only she can set for herself; it " +
                    "is not Sheelah’s job to tell Ramona what she can’t do.\n\n",

            "Consent: Although Daanish and Leanne have not verbally expressed their interest in " +
                    "doing anything sexual, their actions indicate that they are enthusiastic about " +
                    "intimately dancing together.\n\n",

            "Consent: While Dierdre is upset, Rhys handled the situation well. He identified " +
                    "that Dierdre was too intoxicated to consent to any sexual activities, helped her" +
                    " into a safe and comfortable environment, and respected her space by sleeping on " +
                    "the couch. While he could have done other things to help her feel more safe, such" +
                    " as try to contact her friends to help take care of her, or take her home, he did" +
                    " nothing to violate her, or take advantage of her drunken state.\n\n",

            "Consent: even though Daniel isn’t sober and is in a vulnerable state, he is " +
                    "initiating sexual activity and Yael is clearly interested and comfortable.\n\n",

            "Consent: Only Calum can decide what kind of risk he is willing to undertake, and " +
                    "he is actively consenting and communicating with his partner.\n\n",

            "Consent: Even though Yotam is now upset by his actions, he and Sivan engaged in a" +
                    " consensual physical interaction. While he might regret not having thought through" +
                    " all of the repercussions, he actively pursued and enthusiastically consented to " +
                    "sleeping with Sivan.\n\n",

            "Consent: Although the two may be in a public place, both parties are acting in a" +
                    " way that demonstrates that they are enthusiastic and engaged in this physical" +
                    " exchange.\n\n",

            "No Consent: Only Pia can decide what kind of help she wants and needs and what " +
                    "kind of physical support she is comfortable getting from a stranger. Even if this" +
                    " man was trying to help, he needs to be respectful of Pia and her wishes about her" +
                    " body and her ability.\n\n",

            "No Consent: even though Laine might not be able to feel what is going on, Doug" +
                    " still needs to respect her wishes about her body. In light of her different" +
                    " ability, she has less awareness of what happens to certain parts of her body," +
                    " something her partners need to be respectful of, rather than exploitative of.",

            "No Consent: Ian is clearly too drunk to effectively consent, which Dev ignores. " +
                    "He is also unable to communicate and consent to Dev’s actions while he is asleep, " +
                    "which Dev ignores. Although the two were previously flirty, Dev should let Ian " +
                    "sleep and accept that nothing sexual will happen tonight.\n\n",

            "No Consent: Chloe is communicating her comfort level and her boundaries, and Molly" +
                    " continues to pressure Chloe into sexual situations she is not comfortable with.\n\n",

            "No Consent: Jesse doesn't feel comfortable with James having photos of this" +
                    " intimate moment and James must respect this, instead of ignoring Jesse’s wishes." +
                    " James should have asked Jesse how he felt about this before he started taking the" +
                    " photos, and the two could have come to an agreement on how to deal with the new" +
                    " challenges their relationship will face while James is abroad.\n\n",

            "No Consent: Nothing is wrong with Jamar for recognizing that he is too drunk to do" +
                    " anything sexual and wanting to sleep it off. Daya should recognize that he is too" +
                    " drunk and that he is not interested, and should simply wait until tomorrow rather" +
                    " than guilting him.\n\n",

            "No Consent: While Ryan has not explicitly indicated that he is not interested in " +
                    "Heather’s sexual advances, he has demonstrated his disinterest through action. " +
                    "Heather should pay more attention to her partner’s clues, and if she is unclear, " +
                    "she should ask Ryan how he feels, rather than making advances and waiting for him " +
                    "to decline.\n\n",

            "No Consent: Heather is very drunk and not in the frame of mind to decide what " +
                    "boundaries she wants to set with Alex. Alex should either wait until Heather is " +
                    "more sober to make a move, or look for someone else who is more sober for tonight.\n\n",

            "No Consent: In this situation, Noor is too drunk to give proper consent. Niall" +
                    " should respect this and wait to make a move another time. Even though Niall " +
                    "felt pressured by his friends, he should have recognized that Noor had too much " +
                    "to drink and should wait until another opportunity to initiate anything with her.\n\n",

            "No Consent: Klea is too drunk to stay awake and thus, too drunk to be having sex." +
                    " Arman must be respectful of Klea when she withdraws her consent, and not pressure" +
                    " her to continue.\n\n",

            "No Consent: Carla is so intoxicated that it seems she doesn’t know what is " +
                    "happening, and thus can’t properly give consent, regardless of how interested she" +
                    " might seem to Kyle.\n\n",

            "No Consent: in this situation, Robert is in a position of authority, as he is " +
                    "Aarav’s boss. His comments and actions are making Aarav uncomfortable, and he " +
                    "should not be focusing his attention on someone who works for him and is afraid of" +
                    " the repercussions of saying no.\n\n",

            "No Consent: Sandra is clearly uncomfortable and should be able to decide what she" +
                    " wants to have happen to her body on her own, rather than being pressured by " +
                    "someone who has authority over her as a second year and a frosh leader. Khalil " +
                    "should have waited for the end of frosh week or found someone older to hook up " +
                    "with for tonight.\n\n",

            "No Consent: in this situation, Jing is only tolerating the actions of her " +
                    "professor because he is in a position of authority over her and she is afraid he " +
                    "will withhold aid if she declines his advances.\n\n",

            "No Consent: Noah’s teacher is in a position of authority over him, and he is less" +
                    " likely to say no to the advances she is making, even though he is clearly " +
                    "uncomfortable.\n\n",

            "No Consent: Isaac has authority over Asha and is using it to put her in a " +
                    "situation where she is unlikely to say no even though she is clearly " +
                    "uncomfortable. Isaac should have waited at least until the end of frosh week, and" +
                    " tried to make sure she felt like she could say no to him rather than lying and " +
                    "making her uncomfortable.\n\n",

            "No Consent: Even though Alejandra gave consent in the beginning, she can change " +
                    "her mind. Juan should take her uncertainty as an opportunity to talk more and " +
                    "make her feel more comfortable.\n\n",

            "No Consent: Consent cannot be given in advance. Consent is an ongoing process, " +
                    "and just because Kai wanted to do something earlier, this does not mean that this" +
                    " won’t change. Kai should be able to set their own boundaries and Peter should " +
                    "respect this.\n\n",

            "No Consent: Cathy consented to having sex only using a condom, she did not give " +
                    "her consent to having sex without one.\n\n",

            "No Consent: Consent cannot be given in advance, it is an ongoing process. " +
                    "Even though Iris wanted to have sex before, she always has the authority to " +
                    "change her mind and withdraw consent, and she should not be made to feel bad " +
                    "about this decision.\n\n",

            "No Consent: Marieke is clearly communicating that she does not want to have " +
                    "anal sex. Shad should respect this or talk about it with her later instead of " +
                    "repeatedly trying to get her to go along with it.\n\n",

            "No Consent: In this instance, Luke should have confirmed that what he was doing " +
                    "was okay with Amiri, and stopped when she seemed disinterested.\n\n",

            "No Consent: Because Ally and Erin never communicated explicitly about their " +
                    "relationship, both had very different interpretations of their feelings for one" +
                    " another. Ally should have made sure Erin was clearly expressing interest and that" +
                    " she wasn’t just seeing Erin’s actions optimistically.\n\n",

            "No Consent: In this situation, there exists unclear communication. Aaron " +
                    "interpreted Hal’s agreement to go back to his house as consent, which was not the" +
                    " case. Aaron should have been more clear about his intentions, or paid more " +
                    "attention to whether Haruki gave consent.\n\n",

            "No Consent: Although Ursula has not explicitly stated she is uncomfortable, she " +
                    "is clearly demonstrating that she is not interested, which Brad is ignoring. " +
                    "Brad should stop what he is doing, at least until she indicates that she is " +
                    "interested.\n\n",

            "No Consent: In this situation, Tamara is clearly only doing what Emmanuel wants " +
                    "because she doesn’t want them to break up, and not of her own free will. She " +
                    "should be able to make decisions about what she is comfortable doing based on what" +
                    " she wants and not based on fear of losing someone who is important to her.\n\n",

            "No Consent: Even though Tyler is joking around, Deja is clearly conveying that she" +
                    " is uncomfortable, which indicates that consent has not been given. Tyler should" +
                    " respect this and find someone else who reciprocates his advances.\n\n",

            "No Consent: Yuna is very clearly uncomfortable and she should not have to justify" +
                    " her disinterest or explain her sexuality. If Chris only wanted to talk to " +
                    "someone who would be willing to hook up with him, he should have left Yuna on her" +
                    " own and looked for someone else.\n\n",

            "No Consent: this is an example of sexual harassment. The group has no reason to " +
                    "discuss her clothing, and by using objectifying language they are making her feel" +
                    " uncomfortable, when she should be able to wear whatever makes her feel comfortable.\n\n",

            "No Consent: Although the instructor has not made and physical advances, his " +
                    "comments have made Dylan feel so unsafe in her classroom she is no longer able to" +
                    " attend. Dylan should be able to learn in comfort.\n\n",

            "No Consent: Although Aisha is proud of her new body and curated style, she is in" +
                    " no way welcoming these lewd comments or this sexualized attention. She should be" +
                    " able to feel self-confident without being objectified.\n\n",

            "No Consent: Eli has made it clear that she does not yet feel comfortable with this" +
                    " kind of physical intimacy, and Wyatt needs to support her during this process, " +
                    "not pressure her to move on.\n\n",

            "No Consent: In this case, even though Susan and Valeria have had consensual sex " +
                    "many times before this night, Susan is too tired to give consent. Consent can’t be" +
                    " assumed even if it has been given before in a relationship.\n\n",

            "No Consent: Even though they have had sex many times, Simon still needs to get " +
                    "Katya’s consent, which is impossible while she is sleeping. Meanwhile, by trying" +
                    " to move his hand she is clearly conveying a lack of consent.\n\n",

            "No Consent: Even though Eliana and Jared have been together a long time, both " +
                    "parties have to consent to having sex every time. Jared is too drunk and too " +
                    "tired and doesn't want to have sex, and Eliana should wait for tomorrow morning.\n\n",

            "No Consent: Despite their years of being together, Silpa is clearly uncomfortable" +
                    " with Fitz’s behaviour and he should respect her boundaries."
    };

    String[] questionList = new String[20];
    String[] answerList = new String[20];
    Boolean[] score = new Boolean[20];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Integer[] shuffler = new Integer[questions.length];
        int[] questionChoices = new int[20];
        for (int i = 0; i < questions.length; i++) {
            shuffler[i] = i;
        }

        Collections.shuffle(Arrays.asList(shuffler));
        for (int i = 0; i < 20; i++) {
            questionChoices[i] = shuffler[i];
        }

        for (int i = 0; i < 20; i++) {
            questionList[i] = questions[questionChoices[i]];
            answerList[i] = answers[questionChoices[i]];
        }

        genQuestion();

        final ImageButton consentPopup = (ImageButton)findViewById(R.id.imageButton3);
        consentPopup.setOnClickListener(new Button.OnClickListener() {


            @Override
            public void onClick(View arg0) {
                LayoutInflater layoutInflater
                        = (LayoutInflater) getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.custom_popup, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                Button btnDismiss = (Button) popupView.findViewById(R.id.dismiss);
                btnDismiss.setOnClickListener(new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        popupWindow.dismiss();
                        genQuestion();
                    }
                });

                TextView answer = (TextView) popupView.findViewById(R.id.answerText);
                answer.setText(answerList[currentQuestion]);
                if (answerList[currentQuestion].startsWith("C")) {
                    score[currentQuestion] = true;
                }
                else {
                    score[currentQuestion] = false;
                }
                currentQuestion ++;
                popupWindow.showAsDropDown(popupView, 50, -30);
            }
        });

        final ImageButton nonConsentPopup = (ImageButton)findViewById(R.id.imageButton4);
        nonConsentPopup.setOnClickListener(new Button.OnClickListener(){


            @Override
            public void onClick(View arg0) {
                LayoutInflater layoutInflater
                        = (LayoutInflater)getBaseContext()
                        .getSystemService(LAYOUT_INFLATER_SERVICE);
                View popupView = layoutInflater.inflate(R.layout.custom_popup, null);
                final PopupWindow popupWindow = new PopupWindow(
                        popupView,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);

                Button btnDismiss = (Button)popupView.findViewById(R.id.dismiss);
                btnDismiss.setOnClickListener(new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        popupWindow.dismiss();
                        genQuestion();
                    }
                });

                TextView answer = (TextView) popupView.findViewById(R.id.answerText);
                answer.setText(answerList[currentQuestion]);
                if (!answerList[currentQuestion].startsWith("C")) {
                    score[currentQuestion] = true;
                }
                else {
                    score[currentQuestion] = false;
                }
                currentQuestion ++;
                popupWindow.showAsDropDown(popupView, 50, -30);
            }});

    }

    public void genQuestion() {
        if (currentQuestion == 19) {
            Intent i = new Intent(this, studentNumberActivity.class);
            startActivity(i);
        }
        else {
            String questionNum = "QUESTION " + Integer.toString(currentQuestion + 1) + " / 20";

            TextView topHeader = (TextView) findViewById(R.id.questionNumberTextView);
            topHeader.setText(questionNum);

            String questionText = questionList[currentQuestion];

            SpannableString spannedText = new SpannableString(questionText);

            spannedText.setSpan(new ForegroundColorSpan(Color.BLACK), 0, questionText.length(), 0);
            spannedText.setSpan(new RelativeSizeSpan(1.6f), 0, questionText.length(), 0);
            spannedText.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER), 0, questionText.length(), 0);

            TextView scrollyText = (TextView) findViewById(R.id.questionTextView);
            scrollyText.setMovementMethod(new ScrollingMovementMethod());
            scrollyText.setBackgroundResource(android.R.color.white);
            scrollyText.setText(spannedText);
        }
    }
}
