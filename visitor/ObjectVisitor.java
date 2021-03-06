//
// Generated by JTB 1.2.2
//

package visitor;
import syntaxtree.*;
import java.util.*;

/**
 * All Object visitors must implement this interface.
 */
public interface ObjectVisitor {
   //
   // Object Auto class visitors
   //
   public Object visit(NodeList n, Object argu);
   public Object visit(NodeListOptional n, Object argu);
   public Object visit(NodeOptional n, Object argu);
   public Object visit(NodeSequence n, Object argu);
   public Object visit(NodeToken n, Object argu);

   //
   // User-generated visitor methods below
   //

   /**
    * f0 -> ( TopLevelDeclaration() )*
    * f1 -> <EOF>
    */
   public Object visit(File n, Object argu);

   /**
    * f0 -> MainClass()
    *       | ClassDeclaration()
    */
   public Object visit(TopLevelDeclaration n, Object argu);

   /**
    * f0 -> "public"
    * f1 -> "class"
    * f2 -> Identifier()
    * f3 -> "{"
    * f4 -> "public"
    * f5 -> "static"
    * f6 -> "void"
    * f7 -> "main"
    * f8 -> "("
    * f9 -> "String"
    * f10 -> "["
    * f11 -> "]"
    * f12 -> Identifier()
    * f13 -> ")"
    * f14 -> "{"
    * f15 -> Statement()
    * f16 -> "}"
    * f17 -> "}"
    */
   public Object visit(MainClass n, Object argu);

   /**
    * f0 -> "class"
    * f1 -> Identifier()
    * f2 -> "{"
    * f3 -> ( ClassMember() )*
    * f4 -> "}"
    */
   public Object visit(ClassDeclaration n, Object argu);

   /**
    * f0 -> MethodDeclaration()
    *       | ConstantDeclaration()
    *       | UpdatableFieldDeclaration()
    */
   public Object visit(ClassMember n, Object argu);

   /**
    * f0 -> "public"
    * f1 -> "static"
    * f2 -> "final"
    * f3 -> Type()
    * f4 -> Identifier()
    * f5 -> "="
    * f6 -> Expression()
    * f7 -> ";"
    */
   public Object visit(ConstantDeclaration n, Object argu);

   /**
    * f0 -> "public"
    * f1 -> Type()
    * f2 -> Identifier()
    * f3 -> ";"
    */
   public Object visit(UpdatableFieldDeclaration n, Object argu);

   /**
    * f0 -> "public"
    * f1 -> ReturnType()
    * f2 -> Identifier()
    * f3 -> "("
    * f4 -> ( FormalParameterList() )?
    * f5 -> ")"
    * f6 -> Block()
    */
   public Object visit(MethodDeclaration n, Object argu);

   /**
    * f0 -> FormalParameter()
    * f1 -> ( FormalParameterRest() )*
    */
   public Object visit(FormalParameterList n, Object argu);

   /**
    * f0 -> FinalFormalParameter()
    *       | UpdatableFormalParameter()
    */
   public Object visit(FormalParameter n, Object argu);

   /**
    * f0 -> "final"
    * f1 -> Type()
    * f2 -> Identifier()
    */
   public Object visit(FinalFormalParameter n, Object argu);

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    */
   public Object visit(UpdatableFormalParameter n, Object argu);

   /**
    * f0 -> ","
    * f1 -> FormalParameter()
    */
   public Object visit(FormalParameterRest n, Object argu);

   /**
    * f0 -> VoidType()
    *       | Type()
    */
   public Object visit(ReturnType n, Object argu);

   /**
    * f0 -> "void"
    */
   public Object visit(VoidType n, Object argu);

   /**
    * f0 -> UpdatableArrayType()
    *       | NonArrayType()
    */
   public Object visit(Type n, Object argu);

   /**
    * f0 -> NonArrayType()
    * f1 -> "["
    * f2 -> ":"
    * f3 -> RankEquation()
    * f4 -> "]"
    */
   public Object visit(UpdatableArrayType n, Object argu);

   /**
    * f0 -> "rank"
    * f1 -> "=="
    * f2 -> IntegerLiteral()
    */
   public Object visit(RankEquation n, Object argu);

   /**
    * f0 -> BooleanType()
    *       | IntegerType()
    *       | DoubleType()
    *       | StringType()
    *       | PlaceType()
    *       | DistType()
    *       | RegionType()
    *       | PointType()
    *       | ClassNameType()
    */
   public Object visit(NonArrayType n, Object argu);

   /**
    * f0 -> "boolean"
    */
   public Object visit(BooleanType n, Object argu);

   /**
    * f0 -> "int"
    */
   public Object visit(IntegerType n, Object argu);

   /**
    * f0 -> "double"
    */
   public Object visit(DoubleType n, Object argu);

   /**
    * f0 -> "String"
    */
   public Object visit(StringType n, Object argu);

   /**
    * f0 -> "place"
    */
   public Object visit(PlaceType n, Object argu);

   /**
    * f0 -> "dist"
    * f1 -> "("
    * f2 -> ":"
    * f3 -> RankEquation()
    * f4 -> ")"
    */
   public Object visit(DistType n, Object argu);

   /**
    * f0 -> "region"
    * f1 -> "("
    * f2 -> ":"
    * f3 -> RankEquation()
    * f4 -> ")"
    */
   public Object visit(RegionType n, Object argu);

   /**
    * f0 -> "point"
    * f1 -> "("
    * f2 -> ":"
    * f3 -> RankEquation()
    * f4 -> ")"
    */
   public Object visit(PointType n, Object argu);

   /**
    * f0 -> Identifier()
    */
   public Object visit(ClassNameType n, Object argu);

   /**
    * f0 -> <IDENTIFIER>
    */
   public Object visit(Identifier n, Object argu);

   /**
    * f0 -> Assignment()
    *       | AsyncStatement()
    *       | Block()
    *       | FinishStatement()
    *       | IfStatement()
    *       | LoopStatement()
    *       | PostfixStatement()
    *       | PrintlnStatement()
    *       | ReturnStatement()
    *       | ThrowStatement()
    *       | WhileStatement()
    */
   public Object visit(Statement n, Object argu);

   /**
    * f0 -> Expression()
    * f1 -> "="
    * f2 -> Expression()
    * f3 -> ";"
    */
   public Object visit(Assignment n, Object argu);

   /**
    * f0 -> "async"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Block()
    */
   public Object visit(AsyncStatement n, Object argu);

   /**
    * f0 -> "{"
    * f1 -> ( BlockStatement() )*
    * f2 -> "}"
    */
   public Object visit(Block n, Object argu);

   /**
    * f0 -> FinalVariableDeclaration()
    *       | UpdatableVariableDeclaration()
    *       | Statement()
    */
   public Object visit(BlockStatement n, Object argu);

   /**
    * f0 -> "final"
    * f1 -> Type()
    * f2 -> Identifier()
    * f3 -> "="
    * f4 -> Expression()
    * f5 -> ";"
    */
   public Object visit(FinalVariableDeclaration n, Object argu);

   /**
    * f0 -> Type()
    * f1 -> Identifier()
    * f2 -> "="
    * f3 -> Expression()
    * f4 -> ";"
    */
   public Object visit(UpdatableVariableDeclaration n, Object argu);

   /**
    * f0 -> "finish"
    * f1 -> Statement()
    */
   public Object visit(FinishStatement n, Object argu);

   /**
    * f0 -> "if"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    * f5 -> [ ElseClause() ]
    */
   public Object visit(IfStatement n, Object argu);

   /**
    * f0 -> "else"
    * f1 -> Statement()
    */
   public Object visit(ElseClause n, Object argu);

   /**
    * f0 -> "for"
    * f1 -> "("
    * f2 -> PointType()
    * f3 -> ExplodedSpecification()
    * f4 -> ":"
    * f5 -> Expression()
    * f6 -> ")"
    * f7 -> Statement()
    */
   public Object visit(LoopStatement n, Object argu);

   /**
    * f0 -> IdentifierList()
    */
   public Object visit(ExplodedSpecification n, Object argu);

   /**
    * f0 -> Identifier()
    */
   public Object visit(PointName n, Object argu);

   /**
    * f0 -> "["
    * f1 -> Identifier()
    * f2 -> ( IdentifierRest() )*
    * f3 -> "]"
    */
   public Object visit(IdentifierList n, Object argu);

   /**
    * f0 -> ","
    * f1 -> Identifier()
    */
   public Object visit(IdentifierRest n, Object argu);

   /**
    * f0 -> Expression()
    * f1 -> ";"
    */
   public Object visit(PostfixStatement n, Object argu);

   /**
    * f0 -> "System.out.println"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> ";"
    */
   public Object visit(PrintlnStatement n, Object argu);

   /**
    * f0 -> "return"
    * f1 -> [ Expression() ]
    * f2 -> ";"
    */
   public Object visit(ReturnStatement n, Object argu);

   /**
    * f0 -> "throw"
    * f1 -> "new"
    * f2 -> "RuntimeException"
    * f3 -> "("
    * f4 -> Expression()
    * f5 -> ")"
    * f6 -> ";"
    */
   public Object visit(ThrowStatement n, Object argu);

   /**
    * f0 -> "while"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    * f4 -> Statement()
    */
   public Object visit(WhileStatement n, Object argu);

   /**
    * f0 -> InclusiveOrExpression()
    *       | EqualsExpression()
    *       | NotEqualsExpression()
    *       | GreaterThanExpression()
    *       | PlusExpression()
    *       | MinusExpression()
    *       | TimesExpression()
    *       | DivideExpression()
    *       | SinExpression()
    *       | CosExpression()
    *       | PowExpression()
    *       | AbsExpression()
    *       | MapExpression()
    *       | RegionConstant()
    *       | UnaryMinusExpression()
    *       | CoercionToIntExpression()
    *       | CoercionToDoubleExpression()
    *       | TypeAnnotatedExpression()
    *       | FactoryBlock()
    *       | ArrayAccess()
    *       | DotDistribution()
    *       | DotIsFirst()
    *       | DotMethodCall()
    *       | DotIdentifier()
    *       | PrimaryExpression()
    */
   public Object visit(Expression n, Object argu);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "|"
    * f2 -> Expression()
    */
   public Object visit(InclusiveOrExpression n, Object argu);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "=="
    * f2 -> Expression()
    */
   public Object visit(EqualsExpression n, Object argu);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "!="
    * f2 -> Expression()
    */
   public Object visit(NotEqualsExpression n, Object argu);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> ">"
    * f2 -> Expression()
    */
   public Object visit(GreaterThanExpression n, Object argu);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "+"
    * f2 -> Expression()
    */
   public Object visit(PlusExpression n, Object argu);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "-"
    * f2 -> Expression()
    */
   public Object visit(MinusExpression n, Object argu);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "*"
    * f2 -> Expression()
    */
   public Object visit(TimesExpression n, Object argu);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "/"
    * f2 -> Expression()
    */
   public Object visit(DivideExpression n, Object argu);

   /**
    * f0 -> "Math"
    * f1 -> "."
    * f2 -> "sin"
    * f3 -> "("
    * f4 -> Expression()
    * f5 -> ")"
    */
   public Object visit(SinExpression n, Object argu);

   /**
    * f0 -> "Math"
    * f1 -> "."
    * f2 -> "cos"
    * f3 -> "("
    * f4 -> Expression()
    * f5 -> ")"
    */
   public Object visit(CosExpression n, Object argu);

   /**
    * f0 -> "Math"
    * f1 -> "."
    * f2 -> "pow"
    * f3 -> "("
    * f4 -> Expression()
    * f5 -> ","
    * f6 -> Expression()
    * f7 -> ")"
    */
   public Object visit(PowExpression n, Object argu);

   /**
    * f0 -> "Math"
    * f1 -> "."
    * f2 -> "abs"
    * f3 -> "("
    * f4 -> Expression()
    * f5 -> ")"
    */
   public Object visit(AbsExpression n, Object argu);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "->"
    * f2 -> PrimaryExpression()
    */
   public Object visit(MapExpression n, Object argu);

   /**
    * f0 -> "["
    * f1 -> ColonExpression()
    * f2 -> ( ColonRest() )?
    * f3 -> "]"
    */
   public Object visit(RegionConstant n, Object argu);

   /**
    * f0 -> ","
    * f1 -> ColonExpression()
    */
   public Object visit(ColonRest n, Object argu);

   /**
    * f0 -> ColonPair()
    *       | Expression()
    */
   public Object visit(ColonExpression n, Object argu);

   /**
    * f0 -> Expression()
    * f1 -> ":"
    * f2 -> Expression()
    */
   public Object visit(ColonPair n, Object argu);

   /**
    * f0 -> "-"
    * f1 -> PrimaryExpression()
    */
   public Object visit(UnaryMinusExpression n, Object argu);

   /**
    * f0 -> "("
    * f1 -> "int"
    * f2 -> ")"
    * f3 -> Expression()
    */
   public Object visit(CoercionToIntExpression n, Object argu);

   /**
    * f0 -> "("
    * f1 -> "double"
    * f2 -> ")"
    * f3 -> Expression()
    */
   public Object visit(CoercionToDoubleExpression n, Object argu);

   /**
    * f0 -> "("
    * f1 -> TypeAnnotation()
    * f2 -> ")"
    * f3 -> Expression()
    */
   public Object visit(TypeAnnotatedExpression n, Object argu);

   /**
    * f0 -> UpdatableArrayType()
    *       | DistType()
    */
   public Object visit(TypeAnnotation n, Object argu);

   /**
    * f0 -> Literal()
    *       | This()
    *       | AllocationExpression()
    *       | Identifier()
    */
   public Object visit(PrimaryExpression n, Object argu);

   /**
    * f0 -> "this"
    */
   public Object visit(This n, Object argu);

   /**
    * f0 -> "dist.factory.block"
    * f1 -> "("
    * f2 -> Expression()
    * f3 -> ")"
    */
   public Object visit(FactoryBlock n, Object argu);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "["
    * f2 -> ExpressionList()
    * f3 -> "]"
    */
   public Object visit(ArrayAccess n, Object argu);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "."
    * f2 -> Identifier()
    * f3 -> "("
    * f4 -> ( ExpressionList() )?
    * f5 -> ")"
    */
   public Object visit(DotMethodCall n, Object argu);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "."
    * f2 -> "distribution"
    */
   public Object visit(DotDistribution n, Object argu);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "."
    * f2 -> "isFirst"
    * f3 -> "("
    * f4 -> ")"
    */
   public Object visit(DotIsFirst n, Object argu);

   /**
    * f0 -> PrimaryExpression()
    * f1 -> "."
    * f2 -> Identifier()
    */
   public Object visit(DotIdentifier n, Object argu);

   /**
    * f0 -> NewObject()
    *       | NewUpdatableArray()
    */
   public Object visit(AllocationExpression n, Object argu);

   /**
    * f0 -> "new"
    * f1 -> Identifier()
    * f2 -> "("
    * f3 -> [ ExpressionList() ]
    * f4 -> ")"
    */
   public Object visit(NewObject n, Object argu);

   /**
    * f0 -> "new"
    * f1 -> NonArrayType()
    * f2 -> "["
    * f3 -> Identifier()
    * f4 -> "]"
    * f5 -> [ ArrayInitializer() ]
    */
   public Object visit(NewUpdatableArray n, Object argu);

   /**
    * f0 -> IntegerLiteral()
    *       | FloatingPointLiteral()
    *       | StringLiteral()
    *       | HereLiteral()
    *       | DistUnique()
    */
   public Object visit(Literal n, Object argu);

   /**
    * f0 -> <INTEGER_LITERAL>
    */
   public Object visit(IntegerLiteral n, Object argu);

   /**
    * f0 -> <FLOATING_POINT_LITERAL>
    */
   public Object visit(FloatingPointLiteral n, Object argu);

   /**
    * f0 -> <STRING_LITERAL>
    */
   public Object visit(StringLiteral n, Object argu);

   /**
    * f0 -> "here"
    */
   public Object visit(HereLiteral n, Object argu);

   /**
    * f0 -> "dist.UNIQUE"
    */
   public Object visit(DistUnique n, Object argu);

   /**
    * f0 -> Expression()
    * f1 -> ( ArgumentRest() )*
    */
   public Object visit(ExpressionList n, Object argu);

   /**
    * f0 -> ","
    * f1 -> Expression()
    */
   public Object visit(ArgumentRest n, Object argu);

   /**
    * f0 -> "("
    * f1 -> PointType()
    * f2 -> ExplodedSpecification()
    * f3 -> ")"
    * f4 -> Block()
    */
   public Object visit(ArrayInitializer n, Object argu);

}
