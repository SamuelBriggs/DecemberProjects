package ClassProjects.CheckoutApp.CreditCardValidator.MyerBriggsProject;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MBTIServerClass {
    final String[][] questions = {{"A. expend energy, enjoy groups\t\t\t", "B. Conserve Energy, Enjoy one-one-one"},
            {"A. Interpret Literally\t\t\t", "B. Look for meaning and possibilities"},
            {"A. Logical, thinking, questioning\t\t", "B. Empathetic, feeling, accomodating"},
            {"A. Organized, orderly\t\t\t", "B. Flexible, adaptable"},
            {"A. More Outgoing, think out loud\t\t\t", "B. More reserved, think to yourself"},
            {"A. Practical, realistic, experiential\t\t\t", "B. imaginative, innovative, theoretical"},
            {"A. Candid, Straight forward, frank \t\t\t", "B. tactful, kind, encouraging"},
            {"A. Plan, schedule \t\t\t", "B. Unplanned, spontaneous"},
            {"A. Seek Many tasks, public activities, interaction with others, \t\t\t", " B. Seek private, solitary activities with quiet to concentrate"},
            {"A. Standard, Usual, conventional \t\t\t", " B. Different, novel, Unique"},
            {"A. Firm, tend to criticize, hold the line \t\t\t", " B. gentle, tend to appreciate, conciliate"},
            {"A. Regulated, structured \t\t\t", "B. Easy-going, live and let live"},
            {"A. External, Communicative express yourself, \t\t\t", "B. Internal, reticent, keep to yourself"},
            {"A. Focus on here-and-now \t\t\t", "B. Look to the future, global perspective, big picture"},
            {"A. Tough-minded, just \t\t\t", "B. Tender-hearted, merciful"},
            {"A. Preparation, plan ahead \t\t\t", " B. Go with the flow, adapt as you go"},
            {"17. A. Active, initiate \t\t\t\t\t\t", "B. reflective, deliberate"},
            {"18. A. Fact, things, what is \t\t\t\t", " B. ideas, dreams, what could be, philosophical"},
            {"19. A. Matter of fact, issue-oriented \t\t\t", "B. Sensitive, People-oriented, compassionate"},
            {"20. A. Control, govern \t\t\t\t\t ", " B. Latitude, freedom "}};


    static  ArrayList<String> answers = new ArrayList<>();
    static  ArrayList<String> saveAnswers = new ArrayList<>();


    Scanner scanner = new Scanner(System.in);
    String name;

    public void setName() {
        System.out.println("What is your name: ");
        this.name = scanner.nextLine();
    }

    public void serveQuestions() {
        int counter = 0;
        String answer;
        System.out.print(questions[counter][counter]);
        System.out.println(questions[counter][1]);
        int index = 0;
        answer = scanner.next();
        for (int i = 1; i < questions.length; i++) {
            int count = 0;
            int saveAnswerCount = 0;
            while (!answer.equalsIgnoreCase("a") && !answer.equalsIgnoreCase("b")) {
                System.out.println("Enter a Valid Input");
                answer = scanner.next();
            }
            if (answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("b")) {
                answers.add(answer);
                if (answer.equalsIgnoreCase("a")) saveAnswers.add(index, questions[index][saveAnswerCount]);
                else saveAnswers.add(index, questions[index][++saveAnswerCount]);
                System.out.print(questions[i][count]);
                count++;
                System.out.println(questions[i][count]);
                answer = scanner.next();
            }
            index++;
        }
        answers.add(answer);
        if (answer.equalsIgnoreCase("a")) saveAnswers.add(index, questions[index][0]);
        else saveAnswers.add(index, questions[index][1]);
    }

    public ArrayList<String> extroOrIntroResponses() {
        ArrayList<String> extroOrIntro = new ArrayList<>();
        for (int i = 0; i < saveAnswers.size(); i = i + 4) {
            extroOrIntro.add(saveAnswers.get(i));
        }
        return extroOrIntro;
    }

    public ArrayList<String> sensingIntuitiveResponses() {
        ArrayList<String> sOrR = new ArrayList<>();
        for (int i = 1; i < saveAnswers.size(); i = i + 4) {
            sOrR.add(saveAnswers.get(i));
        }
        return sOrR;
    }

    public ArrayList<String> thinkingOrFeelingResponses() {
        ArrayList<String> tOrF = new ArrayList<>();
        for (int i = 2; i < saveAnswers.size(); i = i + 4) {
            tOrF.add(saveAnswers.get(i));
        }
        return tOrF;
    }
    public ArrayList<String> judgingOrPerceptive() {
        ArrayList<String> jOrP = new ArrayList<>();
        for (int i = 3; i < saveAnswers.size(); i = i + 4) {
            jOrP.add(saveAnswers.get(i));
        }
        return jOrP;
    }

    public static String extroIntroAnalysis(){
        String result;
        int countA = 0;
        int countB = 0;
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < answers.size() ; i=i+4){
                arr.add(answers.get(i));
        }

        for (String count: arr) {
            if (count.equalsIgnoreCase("a")) countA ++;
            else countB++;
        }
        if (countA > countB) result = "E";
        else result = "I";
        return result;
    }

    public String sensingIntuitiveAnalysis(){
        String result;
        int countA = 0;
        int countB = 0;
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 1; i < answers.size() ; i=i+4){
            arr.add(answers.get(i));
        }

        for (String count: arr) {
            if (count.equalsIgnoreCase("a")) countA ++;
            else countB++;
        }


        if (countA > countB) result = "S";
        else result = "N";
        return result;
    }

    public String thinkingFeelingAnalysis(){
        String result;
        int countA = 0;
        int countB = 0;
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 2; i < answers.size() ; i=i+4){
            arr.add(answers.get(i));
        }

        for (String count: arr) {
            if (count.equalsIgnoreCase("a")) countA ++;
            else countB++;
        }
        if (countA > countB)
            return "T";
        else
            return "F";
    }

    public String judgingPerceptiveAnalysis(){

        int countA = 0;
        int countB = 0;
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 3; i < answers.size() ; i=i+4){
            arr.add(answers.get(i));
        }
        for (String count: arr) {
            if (count.equalsIgnoreCase("a")) countA ++;
            else countB++;
        }

        if (countA > countB){
            return "J";}
        return "P" ;
    }

    public void displaySelections(ArrayList<String> arr){
        for (String string : arr) {
            System.out.println(string);
        }
    }
    public String displayCombinations(){
        String eOri = extroIntroAnalysis();
        String sOrI = sensingIntuitiveAnalysis();
        String tOrF = thinkingFeelingAnalysis();
        String jOrP = judgingPerceptiveAnalysis();

        return eOri + sOrI + tOrF + jOrP;
    }

    public void printNumberOfAsAndBsInExtroIntro(){

        int countA = 0;
        int countB = 0;

        for (int i = 0; i < answers.size(); i=i+4) {
            if(answers.get(i).equalsIgnoreCase("a")) countA++;
            else countB++;
        }
        System.out.println("Number of A selected: " + countA);
        System.out.println("Number of B selected: "  + countB);



    }
    public void printNumberOfAsAndBsInSensingIntuitive(){
        int countA = 0;
        int countB = 0;
        for (int i = 1; i < answers.size(); i=i+4) {
            if(answers.get(i).equalsIgnoreCase("a")) countA++;
            else countB++;
        }
        System.out.println("Number of A selected: " + countA);
        System.out.println("Number of B selected: "  + countB);
    }
    public void printNumberOfAsAndBsInThinkingFeeling(){
        int countA = 0;
        int countB = 0;
        for (int i = 2; i < answers.size(); i=i+4) {
            if(answers.get(i).equalsIgnoreCase("a")) countA++;
            else countB++;
        }
        System.out.println("Number of A selected: " + countA);
        System.out.println("Number of B selected: "  + countB);
    }
    public void printNumberOfAsAndBsInJudgingPerspective(){
        int countA = 0;
        int countB = 0;
        for (int i = 3; i < answers.size(); i=i+4) {
            if(answers.get(i).equalsIgnoreCase("a")) countA++;
            else countB++;
        }
        System.out.println("Number of A selected: " + countA);
        System.out.println("Number of B selected: "  + countB);
    }

    public void displayPersonalityTraits(){
        String combination = displayCombinations();

        switch (combination){
            case "ESTJ":
                System.out.println("""
                        
                       Executives are representatives of tradition and order, utilizing their understanding of what is right, wrong and socially acceptable to bring families and communities together. 
                       Embracing the values of honesty, dedication and dignity, people with the Executive personality type are valued for their clear advice and guidance, and they happily lead the way on difficult paths. 
                       Taking pride in bringing people together, Executives often take on roles as community organizers, working hard to bring everyone together in celebration of cherished local events, or in defense of the traditional values that hold families and communities together. 
                   
                        
                        """);
                break;
            case "INFP":
                System.out.println("""
                                                
         A Mediator (INFP) is someone who possesses the Introverted, Intuitive, Feeling, and Prospecting personality traits. 
         These rare personality types tend to be quiet, open-minded, and imaginative, and they apply a caring and creative approach to everything they do.                                       
         Although they may seem quiet or unassuming, Mediators (INFPs) have vibrant, passionate inner lives. Creative and imaginative, they happily lose themselves in daydreams, inventing all sorts of stories and conversations in their minds. These personalities are known for their sensitivity – Mediators can have profound emotional responses to music, art, nature, and the people around them.
                                                
         Idealistic and empathetic, Mediators long for deep, soulful relationships, and they feel called to help others. But because this personality type makes up such a small portion of the population, Mediators may sometimes feel lonely or invisible, adrift in a world that doesn’t seem to appreciate the traits that make them unique.
                                                       
                                                
                        """);
                break;
            case "INTJ":
                System.out.println("""
                        
                        It can be lonely at the top. 
                        As one of the rarest personality types – and one of the most capable – Architects (INTJs) know this all too well. 
                        Rational and quick-witted, Architects pride themselves on their ability to think for themselves, not to mention their uncanny knack for seeing right through phoniness and hypocrisy. 
                        But because their minds are never at rest, Architects may struggle to find people who can keep up with their nonstop analysis of everything around them.
                      
                        """);
                    break;
            case "INTP":
                System.out.println("""
                       
                       Logicians pride themselves on their unique perspectives and vigorous intellect. 
                       They can’t help but puzzle over the mysteries of the universe – which may explain why some of the most influential philosophers and scientists of all time have been Logicians. 
                       This personality type is fairly rare, but with their creativity and inventiveness, Logicians aren’t afraid to stand out from the crowd.
             
                        """);
                break;
            case "ENTJ":
                System.out.println("""
                        
                        Commanders are natural-born leaders. 
                        People with this personality type embody the gifts of charisma and confidence, and project authority in a way that draws crowds together behind a common goal. 
                        However, Commanders are also characterized by an often ruthless level of rationality, using their drive, determination and sharp minds to achieve whatever end they’ve set for themselves. 
                        Perhaps it is best that they make up only three percent of the population, lest they overwhelm the more timid and sensitive personality types that make up much of the rest of the world – but we have Commanders to thank for many of the businesses and institutions we take for granted every day.
                    
                        """);
                break;
            case "ENTP":
                System.out.println("""
                                                
                                                
                        Quick-witted and audacious, Debaters aren’t afraid to disagree with the status quo. 
                        In fact, they’re not afraid to disagree with pretty much anything or anyone.
                        Few things light up people with this personality type more than a bit of verbal sparring – and if the conversation veers into controversial terrain, so much the better.
                        It would be a mistake, though, to think of Debaters as disagreeable or mean-spirited. Instead, people with this personality type are knowledgeable and curious, with a playful sense of humor, and they can be incredibly entertaining. They simply have an offbeat, contrarian idea of fun – one that involves a healthy dose of spirited debate.
                                                
               
                        """);
                break;
            case "INFJ":
                System.out.println("""
                                                
                        Advocates (INFJs) may be the rarest personality type of all, but they certainly leave their mark on the world. 
                        Idealistic and principled, they aren’t content to coast through life – they want to stand up and make a difference. 
                        For Advocate personalities, success doesn’t come from money or status but from seeking fulfillment, helping others, and being a force for good in the world.
                                            
                        While they have lofty goals and ambitions, Advocates shouldn’t be mistaken for idle dreamers. 
                        People with this personality type care about integrity, and they’re rarely satisfied until they’ve done what they know to be right. 
                        Conscientious to the core, they move through life with a clear sense of their values, and they aim never to lose sight of what truly matters – not according to other people or society at large, but according to their own wisdom and intuition.
                                                
                                                
                                                
                        """);

                break;
            case "ENFJ":
                System.out.println("""
                        
                        Protagonists are born leaders, which explains why these personalities can be found among many notable politicians, coaches, and teachers. 
                        Their passion and charisma allow them to inspire others not just in their careers but in every arena of their lives, including their relationships.
                        Few things bring Protagonists a deeper sense of joy and fulfillment than guiding friends and loved ones to grow into their best selves.
                     
                        """);
                break;
            case "ENFP":

                System.out.println("""
                     
                        Campaigners (ENFPs) are true free spirits – outgoing, openhearted, and open-minded. 
                        With their lively, upbeat approach to life, they stand out in any crowd. 
                        But even though they can be the life of the party, Campaigners don’t just care about having a good time. 
                        These personality types run deep – as does their longing for meaningful, emotional connections with other people.
                        
                        """);
                break;

            case "ISTJ":

                System.out.println("""
                                                
                        Logisticians pride themselves on their integrity. 
                        People with this personality type mean what they say, and when they commit to doing something, they make sure to follow through.
                                             
                        This personality type makes up a good portion of the overall population, and while Logisticians may not be particularly flashy or attention-seeking, they do more than their share to keep society on a sturdy, stable foundation. 
                        In their families and their communities, Logisticians often earn respect for their reliability, their practicality, and their ability to stay grounded and logical, even in the most stressful situations.
                                                
                        """);
                break;
            case "ISFJ":
                System.out.println("""
                                                
                        In their unassuming, understated way, Defenders help make the world go round. 
                        Hardworking and devoted, people with this personality type feel a deep sense of responsibility to those around them. Defenders can be counted on to meet deadlines, remember birthdays and special occasions, uphold traditions, and shower their loved ones with gestures of care and support. 
                        But they rarely demand recognition for all that they do, preferring instead to operate behind the scenes.
                                                
                        This is a capable, can-do personality type, with a wealth of versatile gifts. 
                        Though sensitive and caring, Defenders also have excellent analytical abilities and an eye for detail. 
                        And despite their reserve, they tend to have well-developed people skills and robust social relationships. 
                        Defenders are truly more than the sum of their parts, and their varied strengths shine in even the most ordinary aspects of their daily lives.
                                                
                                                
                        """);
                break;

            case "ESFJ":
                System.out.println("""
                        For Consuls, life is sweetest when it’s shared with others. 
                        People with this personality type form the bedrock of many communities, opening their homes – and their hearts – to friends, loved ones, and neighbors.
                                                
                        This doesn’t mean that Consuls like everyone, or that they’re saints. 
                        But Consuls do believe in the power of hospitality and good manners, and they tend to feel a sense of duty to those around them. 
                        Generous and reliable, people with this personality type often take it upon themselves – in ways both large and small – to hold their families and their communities together.
                                                
                                      
                        """);
                break;
            case "ISTP":
                System.out.println("""
                        
                        Virtuosos love to explore with their hands and their eyes, touching and examining the world around them with cool rationalism and spirited curiosity. 
                        People with this personality type are natural Makers, moving from project to project, building the useful and the superfluous for the fun of it, and learning from their environment as they go. Often mechanics and engineers, Virtuosos find no greater joy than in getting their hands dirty pulling things apart and putting them back together, just a little bit better than they were before.
                        
                        """);
                break;

            case "ISFP":
                System.out.println("""
                        Adventurers are true artists – although not necessarily in the conventional sense. 
                        For this personality type, life itself is a canvas for self-expression. 
                        From what they wear to how they spend their free time, Adventurers act in ways that vividly reflect who they are as unique individuals.
                                                
                        And every Adventurer is certainly unique. Driven by curiosity and eager to try new things, people with this personality often have a fascinating array of passions and interests. 
                        With their exploratory spirits and their ability to find joy in everyday life, Adventurers can be among the most interesting people you’ll ever meet. 
                        The only irony? Unassuming and humble, Adventurers tend to see themselves as “just doing their own thing,” so they may not even realize how remarkable they really are.
                                                
                        """);

                break;

            case "ESTP":

                System.out.println("""
                        
                        Entrepreneurs always have an impact on their immediate surroundings – the best way to spot them at a party is to look for the whirling eddy of people flitting about them as they move from group to group. 
                        Laughing and entertaining with a blunt and earthy humor, Entrepreneur personalities love to be the center of attention. 
                        If an audience member is asked to come on stage, Entrepreneurs volunteer – or volunteer a shy friend.
                     
                    """);
                break;

            case "ESFP":

                System.out.println("""
                        
                        If anyone is to be found spontaneously breaking into song and dance, it is the Entertainer personality type. 
                        Entertainers get caught up in the excitement of the moment, and want everyone else to feel that way, too. 
                        No other personality type is as generous with their time and energy as Entertainers when it comes to encouraging others, and no other personality type does it with such irresistible style.
                        
                        """);
                    break;

            default:
                System.out.println("No Case");

        }




    }
    public void analysisDisplay(){

        displaySelections(extroOrIntroResponses());
        printNumberOfAsAndBsInExtroIntro();
        System.out.println();
        displaySelections(sensingIntuitiveResponses());
        printNumberOfAsAndBsInSensingIntuitive();
        System.out.println();
        displaySelections(thinkingOrFeelingResponses());
        printNumberOfAsAndBsInThinkingFeeling();
        System.out.println();
        displaySelections(judgingOrPerceptive());
        printNumberOfAsAndBsInJudgingPerspective();
        System.out.println(displayCombinations());
        displayPersonalityTraits();
    }
}


